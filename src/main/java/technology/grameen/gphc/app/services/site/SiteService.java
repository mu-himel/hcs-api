package technology.grameen.gphc.app.services.site;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.Site;

import java.util.List;

public interface SiteService {

    Page<Site> getAll(Pageable pageable);

    List<Site> getAll();

    Site addSite(Site site);
}
