package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.SiteUser;

import java.util.List;
import java.util.UUID;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, UUID> {

    @Query(value = "SELECT pu FROM ProfileUser pu " +
            "WHERE pu.userId IN (SELECT su.userId FROM SiteUser su)")
    List<?> getUsers();
}
