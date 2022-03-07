package technology.grameen.gphc.app.request;

import technology.grameen.gphc.app.healthapp.entity.site.SiteUser;

import java.util.List;

public class SiteUserRequest {

    List<SiteUser> siteUsers;

    public List<SiteUser> getSiteUsers() {
        return siteUsers;
    }

    public void setSiteUsers(List<SiteUser> siteUsers) {
        this.siteUsers = siteUsers;
    }
}
