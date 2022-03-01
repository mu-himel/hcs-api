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
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.ProfileUser;
import technology.grameen.gphc.app.healthapp.repositories.ProfileUserRepository;
import technology.grameen.gphc.app.request.User;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.repositories.ProfileRepository;
import technology.grameen.gphc.app.request.Credential;
import technology.grameen.gphc.app.request.UserRole;
import technology.grameen.gphc.app.response.SimpleResponse;
import technology.grameen.gphc.app.services.network.NetworkService;

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
    private Environment env;

    @Override
    @Transactional
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Page<?> getAll(Pageable pageable) {
        return profileRepository.findAllProfiles(pageable);
    }

    @Override
    public HashMap register(Profile profile) throws CustomException {

        SimpleResponse sr = null;
        HashMap map = null;

        sr = addUserAccount(profile);
        Profile profileCreated = addProfile(profile);
        if (profileCreated.getId() != null) {
            map = (HashMap) sr.getObj().get();
            if (map != null) {
                String userId = String.valueOf(map.get("id"));

                ProfileUser profileUser = new ProfileUser();
                profileUser.setProfile(profileCreated);
                profileUser.setUserId(userId);
                profileUser.setUsername(map.get("username").toString());
                profileUserRepository.save(profileUser);

                assignDefaultRole(userId);
            }
        }


        return map;
    }

    private SimpleResponse addUserAccount(Profile profile) throws CustomException {
        User user = new User();

        String username = "";
        if(profile.getContactNumber() != null && profile.getEmail() == null){
            username = username.concat(profile.getContactNumber());
            user.addCredential(new Credential("12345678",false));
            user.setEnabled(true);
        }

        if(profile.getEmail() != null){
            user.setEnabled(true);
            username = username.concat(profile.getEmail());
            user.setEmail(profile.getEmail());
            user.addCredential(new Credential("12345678",true));
        }
        user.setUsername(username);
        user.setFirstName(profile.getFirstName());
        user.setLastName(profile.getLastName());

        HttpEntity<?> payload = new HttpEntity(user);
        SimpleResponse sr = null;
        ResponseEntity<SimpleResponse> response = null;
        try {
            response = (ResponseEntity<SimpleResponse>) networkService
                    .post(env.getProperty("auth.user.add"), payload, SimpleResponse.class);

            sr = response.getBody();
        }catch (HttpClientErrorException ex){
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
    public Optional<?> getProfileById(UUID id) {
        return profileRepository.findProfileById(id);
    }

    @Override
    public Optional<?> getProfileByUserId(String id) {
        return profileRepository.findProfileByUserId(id);
    }
}
