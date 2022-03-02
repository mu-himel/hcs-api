package technology.grameen.gphc.app.request;

import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

public class RegistrationRequest {

    private Profile profile;
    private String credential;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }
}
