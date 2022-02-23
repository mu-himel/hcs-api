package technology.grameen.gphc.app.services.config;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.configuration.TriageConfiguration;

public interface TriageConfigService {

    TriageConfiguration addConfig(TriageConfiguration triageConfiguration);

    Page<TriageConfiguration> getAll(Pageable pageable);
}
