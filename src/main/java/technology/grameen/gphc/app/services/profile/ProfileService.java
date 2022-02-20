package technology.grameen.gphc.app.services.profile;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.request.User;

import java.util.HashMap;

public interface ProfileService {

    Profile addProfile(Profile profile);

    HashMap register(Profile profile) throws CustomException;

    void updateProfile(String id, Profile profile);
}
