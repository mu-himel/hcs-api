package technology.grameen.gphc.app.services.subscription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;

import java.util.List;
import java.util.Optional;

public interface PackageService {

    void addPackage(SubscriptionPackage subscriptionPackage) throws CustomException;

    void updatePackage(String id, SubscriptionPackage subscriptionPackage) throws CustomException;

    Optional<?> getPackageById(String id);

    Optional<?> findByPackageTitle(String title);

    Optional<?> findByPackageCode(String code);

    Page<?> getAll(String name, Pageable pageable);

    List<?> getAll(String orElse);
}
