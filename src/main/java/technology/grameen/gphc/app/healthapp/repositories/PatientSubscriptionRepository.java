package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientSubscriptionRepository extends JpaRepository<PatientSubscription, UUID> {

    @Query(value = "SELECT ps FROM PatientSubscription ps " +
            "JOIN FETCH ps.subscriptionPackage sp " +
            "JOIN FETCH sp.services s " +
            "WHERE ps.profile=:profile")
    Optional<PatientSubscriptionInfo> findSubscriptionByProfile(@Param("profile") Profile profile);

    @Query(value = "SELECT ps FROM PatientSubscription ps " +
            "JOIN FETCH ps.subscriptionPackage sp " +
            "JOIN FETCH ps.profile p ",
    countQuery = "SELECT ps FROM PatientSubscription ps " +
            "JOIN ps.subscriptionPackage sp " +
            "JOIN ps.profile p ")
    Page<PatientSubscriptionListInfo> findSubscriptions(Pageable pageable);

    @Query(value = "SELECT ps FROM PatientSubscription ps " +
            "JOIN FETCH ps.subscriptionPackage sp " +
            "JOIN FETCH sp.services s " +
            "WHERE ps.id=:id")
    Optional<PatientSubscriptionInfo> findSubscriptionById(@Param("id") UUID id);

    @Query(value = "SELECT ps FROM PatientSubscription ps " +
            "JOIN FETCH ps.subscriptionPackage sp " +
            "JOIN FETCH sp.services s " +
            "WHERE ps.code=:code AND ps.profile = :profile")
    Optional<PatientSubscriptionInfo> findSubscriptionByCodeAndProfile(@Param("code") String code,
                                                                       @Param("profile") Profile profile);



    interface PatientSubscriptionListInfo{
        UUID getId();
        ProfileInfo getProfile();
        PackageInfo getSubscriptionPackage();
        BigDecimal getTotalAmount();
        String getCode();
        String getStatus();
        String getPaymentStatus();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getCreatedAt();
    }

    interface ProfileInfo{
        UUID getId();
        String getFirstName();
        String getLastName();
        ProfileRepository.SiteInfo getSite();
    }

    interface PackageInfo{
        UUID getId();
        String getPackageTitle();
    }



    interface PatientSubscriptionInfo{
        UUID getId();
        String getCode();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getStartDate();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getEndDate();

        String getStatus();
        String getPaymentStatus();

        BigDecimal getTotalAmount();
        BigDecimal getDiscountedAmount();

        ProfileInfo getProfile();

        SubscriptionPackageRepository.SubscriptionPackageInfo getSubscriptionPackage();
    }
}
