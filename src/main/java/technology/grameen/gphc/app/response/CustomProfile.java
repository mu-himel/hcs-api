package technology.grameen.gphc.app.response;

import technology.grameen.gphc.app.healthapp.entity.site.Site;

import java.util.UUID;

public class CustomProfile {
    private UUID id;
    private String firstName;
    private String lastName;
    private Site site;

    public CustomProfile(UUID id, String firstName, String lastName, UUID siteId, String site) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.site = new Site();
        this.site.setId(siteId);
        this.site.setTitle(site);
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site.setTitle(site);
    }
}
