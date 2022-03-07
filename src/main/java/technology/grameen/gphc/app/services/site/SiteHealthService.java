package technology.grameen.gphc.app.services.site;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SiteService;

import java.util.List;

public interface SiteHealthService {

    void add(List<SiteService> siteServices) throws CustomException;

    List<?> getHealthServices(Site site);
}
