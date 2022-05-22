package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import technology.grameen.gphc.app.healthapp.entity.profile.MedicalHistory;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, UUID> {

    @Query(value = "SELECT mh FROM MedicalHistory mh " +
            "JOIN FETCH mh.profile p " +
            "WHERE p.id=:id",
    countQuery = "SELECT count(*) FROM MedicalHistory mh " +
            "JOIN mh.profile p " +
            "WHERE p.id=:id")
    Page<MedicalHistoryInfo> findAllByProfile(@Param("id") UUID profileId, Pageable pageable);

    @Query(value = "SELECT mh FROM MedicalHistory mh " +
            "JOIN FETCH mh.profile p " +
            "WHERE mh.id=:id")
    Optional<MedicalHistoryInfo> findMedicalHistoryById(@Param("id") UUID id);

    interface MedicalHistoryInfo{
        UUID getId();
        Boolean getFirstVisit();

        String getElapsedTimeFromLastMeal();

        Boolean getAnySymptom();

        String getSymptomDetail();

        Boolean getTakingMedicineForFollowingDisease();

        Boolean getHasBloodPressure();
        String getMedicineForBloodPressure();

        Boolean getHasDiabetic();
        String getMedicineForDiabetic();

        Boolean getHasCholesterol();
        String getMedicineForCholesterol();

        String getHypertensiveSufferingDuration();
        String getDiabeticSufferingDuration();
        String getCholesterolSufferingDuration();

        Short getAnyFamilyMemberSuffering();

        Boolean getEverDiagnosedAnemicByDoctor();

        Boolean getRegularSmoker();

        Boolean getHaveAnyDrugAllergy();

        String getAllergicDrugName();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getCreatedAt();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getUpdatedAt();

        Profile getProfile();
    }
}
