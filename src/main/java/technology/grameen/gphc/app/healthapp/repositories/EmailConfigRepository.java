package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.configuration.EmailConfiguration;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmailConfigRepository extends JpaRepository<EmailConfiguration, UUID> {
    Optional<EmailConfiguration> findByIsActive(boolean b);
}
