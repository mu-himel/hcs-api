package technology.grameen.gphc.app.services.subscription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;

import java.util.Optional;

public interface PackageService {

    SubscriptionPackage addPackage(SubscriptionPackage subscriptionPackage);

    Optional<SubscriptionPackage> getPackageById(String id);

    Page<?> getAll(Pageable pageable);
}
