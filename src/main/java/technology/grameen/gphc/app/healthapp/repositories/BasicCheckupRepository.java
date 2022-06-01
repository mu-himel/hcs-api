package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.checkup.BasicCheckup;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BasicCheckupRepository extends JpaRepository<BasicCheckup, UUID> {

    interface PatientCheckup{
        UUID getId();

        PatientProfile getProfile();

        Double getHeight();

        Double getWeight();

        Double getBmi();

        Double getWaistMale();
        Double getWaistFemale();

        Double getHip();

        Double getWaistHipRatioMale();
        Double getWaistHipRatioFemale();

        Double getTemperature();

        Double getOxygenOfBlood();

        Double getBloodPressureSystolic();

        Double getBloodPressureDiastolic();

        Double getBloodSugarFbs();
        String getBloodSugarRbs();
        Double getBloodHemoglobin();
        String getUrineSugar();
        String getUrineProtin();

        String getUrinaryUrobilinogen();

        Double getUrinaryPh();

        Double getPulseRate();

        String getArrhythmia();

        Double getBloodCholesterol();

        Double getBloodUricAcidMale();
        Double getBloodUricAcidFemale();

        String getHbsag();

        String getBloodGrouping();

        String getIsDonor();

        String getSmoking();

        String getAdditionalTest();
        Boolean getPrescribed();

        String getCreatedBy();

        String getUpdatedBy();

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDateTime getCreatedAt();

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDateTime getUpdatedAt();

    }

    interface PatientProfile {
        UUID getId();
        String getFirstName();
        String getLastName();
        Integer getAge();
        String getGender();
        String getPid();
    }

    @Query(value = "SELECT bc FROM BasicCheckup bc " +
            "LEFT JOIN FETCH bc.profile p " +
            "LEFT JOIN FETCH p.site s " +
            "LEFT JOIN FETCH s.country " +
            "WHERE p=:profile order by bc.createdAt asc")
    List<PatientCheckup> findByProfile(Profile profile);

    @Query(value = "SELECT bc FROM BasicCheckup bc " +
            "LEFT JOIN FETCH bc.profile p " +
            "LEFT JOIN FETCH p.site s " +
            "LEFT JOIN FETCH s.country " +
            "WHERE bc.id=:id")
    Optional<PatientCheckup> findCheckupDataById(@Param("id") UUID id);
}
