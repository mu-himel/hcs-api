package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.SiteUser;

import java.util.List;
import java.util.UUID;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, UUID> {

    interface ProfileUser{
        String getFirstName();
        String getLastName();
        String getUserId();
        String getUsername();
    }

    @Query(value = "SELECT pu.username, p.first_name firstName, p.last_name lastName, pu.user_id userId FROM profile_user pu " +
            " join profiles p on p.id = pu.profile_id " +
           " WHERE pu.user_id IN (SELECT su.user_id FROM site_users su WHERE su.site_id = :siteId)",
    nativeQuery = true)
    List<ProfileUser> getUsers(@Param("siteId") UUID siteId);
}
