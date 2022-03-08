package technology.grameen.gphc.app.request;

import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import java.util.Map;

public class UserProfileRequest {
    Profile profile;
    Map<String,Object> user;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Map<String, Object> getUser() {
        return user;
    }

    public void setUser(Map<String, Object> user) {
        this.user = user;
    }
}
