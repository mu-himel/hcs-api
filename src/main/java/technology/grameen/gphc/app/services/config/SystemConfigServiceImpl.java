package technology.grameen.gphc.app.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.configuration.SystemConfiguration;
import technology.grameen.gphc.app.healthapp.repositories.SystemConfigRepository;

import java.util.Optional;

@Service
public class SystemConfigServiceImpl implements SystemConfigService{

    @Autowired
    private SystemConfigRepository systemConfigRepository;

    @Override
    @Transactional
    public void addConfig(SystemConfiguration systemConfiguration) {
        systemConfigRepository.save(systemConfiguration);
    }

    @Override
    public Optional<SystemConfiguration> getSystemConfig() {
        return systemConfigRepository.findAll().stream().findAny();
    }
}
