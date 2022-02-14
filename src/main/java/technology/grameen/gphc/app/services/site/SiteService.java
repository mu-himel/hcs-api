package technology.grameen.gphc.app.services.site;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.Site;

import java.util.List;
import java.util.Optional;

public interface SiteService {

    Page<Site> getAll(Pageable pageable);

    List<Site> getAll();

    SiteUserService getSiteUser();

    Site addSite(Site site) throws CustomException;

    Optional<?> getSiteById(String id);
}
