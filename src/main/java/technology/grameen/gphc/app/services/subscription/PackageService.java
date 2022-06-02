package technology.grameen.gphc.app.services.subscription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;

import java.util.Optional;

public interface PackageService {

    void addPackage(SubscriptionPackage subscriptionPackage);

    void updatePackage(String id, SubscriptionPackage subscriptionPackage);

    Optional<?> getPackageById(String id);

    Page<?> getAll(Pageable pageable);
}
