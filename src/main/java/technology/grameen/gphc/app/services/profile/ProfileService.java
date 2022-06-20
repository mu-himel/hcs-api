package technology.grameen.gphc.app.services.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.profile.ProfileUser;
import technology.grameen.gphc.app.request.RegistrationRequest;

import java.util.*;

public interface ProfileService {

    Profile addProfile(Profile profile);
    ProfileUser addProfileUser(Map<String,Object> userInfo, Profile profile, ProfileUser profileUser);

    HashMap register(Profile profile) throws CustomException;
    HashMap register(RegistrationRequest registrationRequest) throws CustomException;

    void updateProfile(String id, Profile profile) throws CustomException;

    Page<?> getAll(Pageable pageable, Optional<String> firstName, Optional<String> lastName,
                   Optional<String> email, Optional<String> contactNumber,
                   Optional<String> siteId, Optional<String> roleId);

    Optional<?> getProfileById(UUID fromString);
    Optional<?> getProfileByUserId(String id);

    Optional<?> getProfileByEmail(String email);
    Optional<?> getProfileByPid(String pid);
    List<?> getProfileUsers();

    DoctorProfileService getDoctorProfileService();
    ResearcherProfileService getResearcherProfileService();

    void updateRoleOnProfile(String id, String role);
}
