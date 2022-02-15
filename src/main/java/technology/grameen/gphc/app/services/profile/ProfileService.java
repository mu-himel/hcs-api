package technology.grameen.gphc.app.services.profile;

import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

public interface ProfileService {

    Profile addProfile(Profile profile);

    Boolean register(Profile profile);

    void updateProfile(String id, Profile profile);
}
