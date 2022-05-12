package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.ResearcherProfile;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResearcherProfileRepository extends JpaRepository<ResearcherProfile, UUID> {

    interface ResearcherProfile {
        UUID getId();
        String getSpeciality();
        String getDegree();
        String getDegreeYear();
        String getDesignation();
        String getInstitute();

        @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
        LocalDateTime getCreatedAt();
        Profile getProfile();
    }
    interface Profile{
        UUID getId();
    }
    @Query(value = "SELECT rp FROM ResearcherProfile rp " +
            "JOIN FETCH rp.profile p WHERE p.id = :profileId")
    Optional<ResearcherProfile> findByProfileId(@Param("profileId") UUID id);
}
