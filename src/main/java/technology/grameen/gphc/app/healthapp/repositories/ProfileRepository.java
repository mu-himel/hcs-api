package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    interface ProfilePageInfo{
        String getBloodGroup();
        String getContactNumber();
        String getContactNumber2();
        String getEmail();
        String getProfileImage();
        String getFirstName();
        String getLastName();
        String getGuardianName();
        String getIdentityType();
        String getIdentityValue();
        SiteInfo getSite();
        UUID getId();
    }

    interface SiteInfo{
        UUID getId();
        String getTitle();
    }

    @Query(value = "SELECT p FROM Profile p " +
            "JOIN FETCH p.site s",
    countQuery = "SELECT count(p) FROM Profile p JOIN p.site s")
    Page<ProfilePageInfo> findAllProfiles(Pageable pageable);
}
