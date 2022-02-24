package technology.grameen.gphc.app.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.configuration.EmailConfiguration;
import technology.grameen.gphc.app.healthapp.repositories.EmailConfigRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmailConfigServiceImpl implements EmailConfigService {

    @Autowired
    private EmailConfigRepository emailConfigRepository;

    @Override
    @Transactional
    public EmailConfiguration add(EmailConfiguration config) {
        return emailConfigRepository.save(config);
    }

    @Override
    public Page<EmailConfiguration> getAll(Pageable pageable) {
        return emailConfigRepository.findAll(pageable);
    }

    @Override
    public Optional<EmailConfiguration> getDefaultConfig() {
        return emailConfigRepository.findByIsActive(true);
    }

    @Override
    public Optional<EmailConfiguration> getConfig(UUID id) {
        return emailConfigRepository.findById(id);
    }
}
