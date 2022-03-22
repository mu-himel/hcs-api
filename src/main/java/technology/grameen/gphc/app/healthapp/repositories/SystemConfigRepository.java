package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.configuration.SystemConfiguration;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SystemConfigRepository extends JpaRepository<SystemConfiguration, UUID> {

    interface SystemConfig {
        UUID getId();
        String getOrgName();
        String getLogo();
        String getIdentityTypes();
        Integer getNoOfIdentityDigit();
        GeoCountry getCountry();
    }

    interface GeoCountry {
        Long getId();
        String getName();
    }
    @Query("SELECT s FROM SystemConfiguration s LEFT JOIN FETCH s.country c")
    Optional<SystemConfig> findAllSystemConfig();
}
