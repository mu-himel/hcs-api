package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SitePackage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SitePackageRepository extends JpaRepository<SitePackage, UUID> {

    @Query(value = "SELECT sp FROM SitePackage sp " +
            "JOIN FETCH sp.subscriptionPackage sup " +
            "JOIN FETCH sp.site s ",
            countQuery = "SELECT sp FROM SitePackage sp " +
                    "JOIN sp.subscriptionPackage sup " +
                    "JOIN sp.site s ")
    Page<SitePackageListInfo> findAllSubscriptions(Pageable pageable);

    Page<SitePackageListInfo> findBySite(Site site,Pageable pageable);

    Optional<SitePackageListInfo> findSubscriptionById(UUID fromString);

    interface SitePackageListInfo{
        UUID getId();
        SubscriptionPackage getSubscriptionPackage();
        SiteInfo getSite();
        BigDecimal getTotalAmount();
        BigDecimal getDiscountedAmount();
        String getCode();
        String getStatus();
        String getPaymentStatus();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getStartDate();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getEndDate();


    }

    interface SiteInfo{
        UUID getId();
        String getTitle();
    }

    interface SubscriptionPackage{
        UUID getId();
        String getPackageTitle();
        String getPackageCode();
        BigDecimal getTotalAmount();
        Integer getDuration();
        String getDurationType();
        List<Service> getServices();
    }

    interface Service{
        UUID getId();
        String getName();
    }
}
