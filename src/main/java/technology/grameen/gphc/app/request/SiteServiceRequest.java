package technology.grameen.gphc.app.request;

import technology.grameen.gphc.app.healthapp.entity.site.SiteService;

import java.util.List;

public class SiteServiceRequest {

    private List<SiteService> siteServices;

    public List<SiteService> getSiteServices() {
        return siteServices;
    }

    public void setSiteServices(List<SiteService> siteServices) {
        this.siteServices = siteServices;
    }
}
