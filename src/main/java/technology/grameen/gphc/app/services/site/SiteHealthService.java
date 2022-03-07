package technology.grameen.gphc.app.services.site;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.service.Service;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SiteService;

import java.util.List;
import java.util.Optional;

public interface SiteHealthService {

    void add(SiteService siteServices) throws CustomException;

    List<?> getHealthServices(Site site);
    Optional<?> getHealthServiceBySiteAndService(Site site, Service service);
}
