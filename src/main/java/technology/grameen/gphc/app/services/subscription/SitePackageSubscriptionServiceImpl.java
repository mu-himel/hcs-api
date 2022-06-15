package technology.grameen.gphc.app.services.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SitePackage;
import technology.grameen.gphc.app.healthapp.repositories.SitePackageRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SitePackageSubscriptionServiceImpl implements SitePackageSubscriptionService{

    @Autowired
    private SitePackageRepository sitePackageRepository;

    @Override
    @Transactional
    public SitePackage subscribePackage(SitePackage sitePackage) {
        return sitePackageRepository.save(sitePackage);
    }

    @Override
    public Page<?> getSiteSubscriptions(Pageable pageable) {
        return sitePackageRepository.findAllSubscriptions(pageable);
    }

    @Override
    public Page<?> getSiteSubscriptionsBySite(Site site, Pageable pageable) {
        return sitePackageRepository.findBySite(site, pageable);
    }

    @Override
    public Optional<?> getSiteSubscriptionsById(String id) {
        return sitePackageRepository.findSubscriptionById(UUID.fromString(id));
    }
}
