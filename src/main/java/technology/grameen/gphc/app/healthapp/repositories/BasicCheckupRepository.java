package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

        Double getWaist();

        Double getHip();

        Double getWaistHipRatio();

        Double getTemperature();

        Double getOxygenOfBlood();

        Double getBloodPressureSystolic();

        Double getBloodPressureDiastolic();

        Double getBloodGlucose();
        String getBloodGlucoseType();
        Double getBloodHemoglobin();
        String getUrinaryGlucose();
        String getUrinaryProtein();

        String getUrinaryUrobilinogen();

        Double getUrinaryPh();

        Double getPulseRate();

        String getArrhythmia();

        Double getCholesterol();

        Double getUricAcid();

        String getHbsag();

        String getBloodGroup();

        String getIsDonor();

        String getSmoker();

        String getAdditionalTest();

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
    }

    @Query(value = "SELECT bc FROM BasicCheckup bc " +
            "LEFT JOIN FETCH bc.profile p " +
            "JOIN FETCH p.site s " +
            "JOIN FETCH s.country " +
            "WHERE p=:profile")
    List<PatientCheckup> findByProfile(Profile profile);
}
