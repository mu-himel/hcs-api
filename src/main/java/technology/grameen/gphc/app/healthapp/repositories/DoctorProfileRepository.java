package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.DoctorProfile;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorProfileRepository extends JpaRepository<DoctorProfile, UUID> {

    interface DoctorProfile {
        UUID getId();
        String getBmaRegNo();
        String getSpeciality();
        String getDegree();
        String getHospital();
        Profile getProfile();
        String getDesignation();
        String getSignatureFile();
        @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
        LocalDateTime getCreatedAt();
    }
    interface Profile{
        UUID getId();
    }
    @Query(value = "SELECT dp FROM DoctorProfile dp " +
            "JOIN FETCH dp.profile p WHERE p.id = :profileId")
    Optional<DoctorProfile> findByProfileId(@Param("profileId") UUID id);
}
