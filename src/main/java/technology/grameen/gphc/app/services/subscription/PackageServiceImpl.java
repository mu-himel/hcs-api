package technology.grameen.gphc.app.services.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;
import technology.grameen.gphc.app.healthapp.repositories.SubscriptionPackageRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class PackageServiceImpl implements PackageService{

    @Autowired
    private SubscriptionPackageRepository subscriptionPackageRepository;

    @Override
    @Transactional
    public SubscriptionPackage addPackage(SubscriptionPackage subscriptionPackage) {
        return subscriptionPackageRepository.save(subscriptionPackage);
    }

    @Override
    public Optional<SubscriptionPackage> getPackageById(String id) {
        return subscriptionPackageRepository.findById(UUID.fromString(id));
    }

    @Override
    public Page<?> getAll(Pageable pageable) {
        return subscriptionPackageRepository.findAll(pageable);
    }
}
