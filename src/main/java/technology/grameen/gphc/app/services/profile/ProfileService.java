package technology.grameen.gphc.app.services.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.request.User;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public interface ProfileService {

    Profile addProfile(Profile profile);

    HashMap register(Profile profile) throws CustomException;

    void updateProfile(String id, Profile profile);

    Page<?> getAll(Pageable pageable);

    Optional<?> getProfileById(UUID fromString);
}
