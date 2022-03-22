package technology.grameen.gphc.app.services.config;

import technology.grameen.gphc.app.healthapp.entity.configuration.SystemConfiguration;

import java.util.Optional;

public interface SystemConfigService {

    void addConfig(SystemConfiguration systemConfiguration);

    Optional<SystemConfiguration> getSystemConfig();
}
