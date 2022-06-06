package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.service.Service;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubscriptionPackageRepository extends JpaRepository<SubscriptionPackage, UUID> {

    @Query(value = "SELECT p from SubscriptionPackage p JOIN FETCH p.services",
    countQuery = "SELECT count(p) from SubscriptionPackage p JOIN p.services")
    Page<SubscriptionPackageListInfo> findAllPackages(Pageable pageable);

    @Query(value = "SELECT p from SubscriptionPackage p JOIN FETCH p.services " +
            "WHERE lower(p.packageTitle) LIKE (:name||'%')",
            countQuery = "SELECT count(p) from SubscriptionPackage p JOIN p.services" +
                    " WHERE lower(p.packageTitle) LIKE (:name||'%')")
    Page<SubscriptionPackageListInfo> findAllPackagesByName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT p from SubscriptionPackage p JOIN FETCH p.services" +
            " WHERE p.packageTitle=:name")
    List<SubscriptionPackageInfo> findAllPackagesByName(@Param("name") String name);

    @Query(value = "SELECT p from SubscriptionPackage p JOIN FETCH p.services")
    List<SubscriptionPackageInfo> findAllPackages();

    interface SubscriptionPackageInfo{
        UUID getId();
        String getPackageTitle();
        List<Service> getServices();
        String getPackageDetail();
        String getPackageCode();
        BigDecimal getTotalAmount();
        BigDecimal getDiscountedAmount();
    }

    interface SubscriptionPackageListInfo{
        UUID getId();
        String getPackageTitle();
        String getPackageDetail();
        String getPackageCode();
        BigDecimal getTotalAmount();
        BigDecimal getDiscountedAmount();
    }

    interface Service{
        UUID getId();
        String getName();
    }

    @Query(value = "SELECT p from SubscriptionPackage p JOIN FETCH p.services" +
            " WHERE p.id = :id")
    Optional<SubscriptionPackageInfo> findPackageById(@Param("id") UUID fromString);


}
