package technology.grameen.gphc.app.services.subscription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SitePackage;

import java.util.List;
import java.util.Optional;

public interface SitePackageSubscriptionService {
    SitePackage subscribePackage(SitePackage sitePackage);

    Page<?> getSiteSubscriptions(Pageable pageable);

    Page<?> getSiteSubscriptionsBySite(Site site, Pageable pageable);

    Optional<?> getSiteSubscriptionsById(String id);
}
