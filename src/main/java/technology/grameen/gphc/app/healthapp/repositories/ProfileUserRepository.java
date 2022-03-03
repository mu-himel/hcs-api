package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.profile.ProfileUser;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProfileUserRepository extends JpaRepository<ProfileUser, UUID> {

    interface Profile{
        UUID getId();
        String getFirstName();
        String getLastName();
    }

    interface User{
        String getUserId();
        String getUsername();
        Profile getProfile();
    }

    @Query("SELECT pu FROM ProfileUser pu JOIN FETCH pu.profile p")
    List<User> findAllUser();
}
