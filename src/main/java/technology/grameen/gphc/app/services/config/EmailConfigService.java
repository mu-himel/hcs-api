package technology.grameen.gphc.app.services.config;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.configuration.EmailConfiguration;

import java.util.Optional;

public interface EmailConfigService {
    EmailConfiguration add(EmailConfiguration config);

    Page<EmailConfiguration> getAll(Pageable pageable);

    Optional<EmailConfiguration> getDefaultConfig();
}
