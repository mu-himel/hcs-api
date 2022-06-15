package technology.grameen.gphc.app.services.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.site.SitePackage;
import technology.grameen.gphc.app.healthapp.repositories.SitePackageRepository;

import java.util.Optional;

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
}
