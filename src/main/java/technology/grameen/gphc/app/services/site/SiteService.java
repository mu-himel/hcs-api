package technology.grameen.gphc.app.services.site;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SiteUser;

import java.util.List;
import java.util.Optional;

public interface SiteService {

    Page<?> getAll(Pageable pageable);

    List<?> getAll();

    SiteUserService getSiteUser();

    SiteHealthService getSiteHealthService();

    Site addSite(Site site) throws CustomException;

    Optional<?> getSiteById(String id);

    void assignUser(List<SiteUser> siteUsers) throws CustomException;
}
