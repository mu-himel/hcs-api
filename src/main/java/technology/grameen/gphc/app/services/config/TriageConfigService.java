package technology.grameen.gphc.app.services.config;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.configuration.TriageConfiguration;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface TriageConfigService {

    TriageConfiguration addConfig(TriageConfiguration triageConfiguration);

    Page<TriageConfiguration> getAll(Pageable pageable);

    Optional<TriageConfiguration> getConfig(UUID id);

    Map<String, Object> getRef(String triageFor);
}
