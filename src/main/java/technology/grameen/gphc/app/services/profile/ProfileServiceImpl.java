package technology.grameen.gphc.app.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import technology.grameen.gphc.app.auth.repositories.UserRepository;
import technology.grameen.gphc.app.component.UrlBuilder;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.profile.ProfileUser;
import technology.grameen.gphc.app.healthapp.repositories.ProfileRepository;
import technology.grameen.gphc.app.healthapp.repositories.ProfileUserRepository;
import technology.grameen.gphc.app.request.*;
import technology.grameen.gphc.app.request.fhir.CommonProperty;
import technology.grameen.gphc.app.request.fhir.NameInfo;
import technology.grameen.gphc.app.request.fhir.Patient;
import technology.grameen.gphc.app.request.fhir.TextProperty;
import technology.grameen.gphc.app.response.SimpleResponse;
import technology.grameen.gphc.app.services.criteria.ProfileCriteriaRepository;
import technology.grameen.gphc.app.services.network.NetworkService;
import technology.grameen.gphc.app.services.register.FhirRegisterService;
import technology.grameen.gphc.app.services.security.OtpService;

import java.util.*;

@Service
@PropertySource("classpath:application.properties")
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileUserRepository profileUserRepository;

    @Autowired
    private NetworkService networkService;

    @Autowired
    private DoctorProfileService doctorProfileService;

    @Autowired
    private ResearcherProfileService researcherProfileService;

    @Autowired
    private Environment env;

    @Autowired
    private UrlBuilder urlBuilder;

    @Autowired
    private FhirRegisterService registerService;

    @Autowired
    private OtpService otpService;

    @Autowired
    ProfileCriteriaRepository profileCriteriaRepository;

    @Override
    @Transactional
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Page<?> getAll(Pageable pageable, Optional<String> firstName, Optional<String> lastName,
                          Optional<String> email, Optional<String> contactNumber,
                          Optional<String> siteId, Optional<String> roleId) {



        if(!firstName.isPresent() && !lastName.isPresent() &&
                !contactNumber.isPresent() && !email.isPresent()
                && !siteId.isPresent() && !roleId.isPresent()){
            return profileRepository.findAllProfiles(pageable);
        }else{
            return profileCriteriaRepository.findByWhere(pageable, firstName.orElse(""), lastName.orElse(""),
                    email.orElse(""), contactNumber.orElse(""),siteId.orElse(""),
                    roleId.orElse(""));
        }

    }

    @Override
    public HashMap register(Profile profile) throws CustomException {
        return createProfile(profile,"12345678",true, true);
    }

    @Override
    public HashMap register(RegistrationRequest registrationRequest) throws CustomException {
        return createProfile(registrationRequest.getProfile(),registrationRequest.getCredential(), true, false);
    }

    private HashMap createProfile(Profile profile, String credential, Boolean isPublic, Boolean sendEmail) throws CustomException {
        SimpleResponse sr = null;
        HashMap map = null;

        sr = addUserAccount(profile,credential, isPublic, sendEmail);

        Patient patient = new Patient();
        TextProperty maritalStatus = new TextProperty(profile.getMaritalStatus());
        patient.setMaritalStatus(maritalStatus);
        List<CommonProperty> telecom = new ArrayList<>();
        telecom.add(new CommonProperty("email", profile.getEmail(),"home"));
        telecom.add(new CommonProperty("phone", profile.getContactNumber(),"home"));
        telecom.add(new CommonProperty("phone", profile.getContactNumber2(),"work"));
        patient.setTelecom(telecom);
        patient.setGender(profile.getGender());
        List<NameInfo> names = new ArrayList<>();
        names.add(new NameInfo(profile.getFirstName(),profile.getLastName()));
        patient.setName(names);
        Optional<?> patientIdOp = registerService.getPatientId();
        if(patientIdOp.isPresent()){
            Map<String,Object> responseMap = (Map<String, Object>) patientIdOp.get();
            Map<String,String> mapEhrId = (Map<String, String>)responseMap.get("ehr_id");
            patient.setId(mapEhrId.get("value"));
            profile.setId(UUID.fromString(patient.getId()));
            registerService.registerPatient(patient);
        }

        profile.setPid(otpService.generateOtpToken(10));
        Profile profileCreated = addProfile(profile);
        if (profileCreated.getId() != null) {
            map = (HashMap) sr.getObj().get();
            if (map != null) {
                String userId = String.valueOf(map.get("id"));

                addProfileUser(map,profileCreated,new ProfileUser());

                assignDefaultRole(userId);
            }
        }
        return map;
    }

    @Override
    public ProfileUser addProfileUser(Map<String,Object> userInfo, Profile profile, ProfileUser profileUser) {

        profileUser.setProfile(profile);
        profileUser.setUserId(String.valueOf(userInfo.get("id")));
        profileUser.setUsername(String.valueOf(userInfo.get("username").toString()));
        profileUserRepository.save(profileUser);
        return profileUser;
    }

    private SimpleResponse addUserAccount(Profile profile, String credential, Boolean isPublic, Boolean sendEmail) throws CustomException {
        User user = new User();

        String username = "";
        if(profile.getContactNumber() != null && profile.getEmail() == null){
            username = username.concat(profile.getContactNumber());

        }

        if(profile.getEmail()!=null){
            username = username.concat(profile.getEmail());
            user.setEmail(profile.getEmail());
        }

        if(username.isEmpty()){
            throw new CustomException("E-mail address required");
        }

        user.addCredential(new Credential(credential,true));
        user.setEnabled(true);
        user.setUsername(username);
        user.setFirstName(profile.getFirstName());
        user.setLastName(profile.getLastName());
        AuthUserRequest authUserRequest = new AuthUserRequest();
        authUserRequest.setUser(user);
        authUserRequest.setPublic(isPublic);
        authUserRequest.setSendEmail(sendEmail);
        HttpEntity<?> payload = new HttpEntity(authUserRequest);
        SimpleResponse sr = null;
        ResponseEntity<SimpleResponse> response = null;
        try {
            response = (ResponseEntity<SimpleResponse>) networkService
                    .post(env.getProperty("auth.user.add"), payload, SimpleResponse.class);

            sr = response.getBody();
        }catch (HttpClientErrorException ex){
            System.out.println(ex.getMessage());
            if(ex.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY){
                throw new CustomException("User Already Exist");
            }
        }
        return  sr;
    }

    private Boolean assignDefaultRole(String userId){
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        List<Map<String,String>> roles = new ArrayList<>();
        Map<String, String> role = new HashMap<>();
        role.put("id",env.getProperty("profile.default.roleId"));
        role.put("name",env.getProperty("profile.default.roleName"));
        roles.add(role);
        userRole.setRoles(roles);
        HttpEntity<UserRole> payload = new HttpEntity<>(userRole);
        ResponseEntity<?> response = networkService.post(env.getProperty("auth.user.role-map"),
                                        payload,Void.class);

        return response.getStatusCode() == HttpStatus.OK;
    }

    @Override
    @Transactional
    public void updateProfile(String id, Profile profile) {
        Optional<?> profileOp = profileRepository.findProfileByUserId(id);

        if(profileOp.isPresent()){
            ProfileRepository.ProfileUser p = (ProfileRepository.ProfileUser)profileOp.get();
            if(!p.getProfile().getEmail().isEmpty()){
                profile.setEmail(p.getProfile().getEmail());
            }
            profile.setRoleId(p.getProfile().getRoleId());
            profileRepository.save(profile);

            // update user account
            technology.grameen.gphc.app.auth.entity.User user = new technology.grameen.gphc.app.auth.entity.User();
            user.setId(id);
            user.setFirstName(profile.getFirstName());
            user.setLastName(profile.getLastName());
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public void updateRoleOnProfile(String id, String role) {
        Optional<ProfileRepository.ProfileUser> profileOp = profileRepository.findProfileByUserId(id);
        if(profileOp.isPresent()){
            UUID _id = profileOp.get().getProfile().getId();
            profileRepository.updateRole(_id,role);
        }
    }

    @Override
    public Optional<?> getProfileById(UUID id) {

        Optional<ProfileRepository.ProfileUser> profileUserOp = profileRepository.findProfileById(id);
        Map<String, Object> map = new HashMap<>();

        if(profileUserOp.isPresent()) {
            ProfileRepository.ProfileUser profileUser = profileUserOp.get();
            ResponseEntity<?> response = networkService.get(urlBuilder.getRoleEndPoint() + "/"
                    + profileUser.getUserId(), null, Object.class);
            Optional<?> userRole = Optional.ofNullable(response.getBody());

            map.put("profile", profileUser.getProfile());
            map.put("userId", profileUser.getUserId());
            map.put("username", profileUser.getUsername());
            map.put("id", profileUser.getId());
            map.put("role", userRole);
        }

        return Optional.of(map);
    }

    @Override
    public Optional<?> getProfileByPid(String id) {
        Optional<ProfileRepository.ProfilePageInfo> profileUserOp = profileRepository.findByPid(id);


        if(profileUserOp.isPresent()) {
            return Optional.of(profileUserOp.get());
        }

        return Optional.empty();
    }

    @Override
    public Optional<?> getProfileByUserId(String id) {
        return profileRepository.findProfileByUserId(id);
    }

    @Override
    public Optional<?> getProfileByEmail(String email) {
        return profileRepository.findByEmail(email);
    }

    @Override
    public List<?> getProfileUsers() {
        return profileUserRepository.findAllUser();
    }


    @Override
    public DoctorProfileService getDoctorProfileService() {
        return doctorProfileService;
    }

    @Override
    public ResearcherProfileService getResearcherProfileService() {
        return researcherProfileService;
    }
}
