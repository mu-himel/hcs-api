package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.configuration.TriageConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public interface TriageConfigRepository extends JpaRepository<TriageConfiguration, UUID> {
    List<TriageConfiguration> findByTriageFor(String triageFor);
}
