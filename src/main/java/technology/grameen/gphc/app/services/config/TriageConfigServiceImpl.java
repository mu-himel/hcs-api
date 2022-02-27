package technology.grameen.gphc.app.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.configuration.TriageConfiguration;
import technology.grameen.gphc.app.healthapp.repositories.TriageConfigRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class TriageConfigServiceImpl implements TriageConfigService{

    @Autowired
    private TriageConfigRepository triageConfigRepository;

    @Override
    @Transactional
    public TriageConfiguration addConfig(TriageConfiguration triageConfiguration) {
        return triageConfigRepository.save(triageConfiguration);
    }

    @Override
    public Page<TriageConfiguration> getAll(Pageable pageable) {
        return triageConfigRepository.findAll(pageable);
    }

    @Override
    public Optional<TriageConfiguration> getConfig(UUID id) {
        return triageConfigRepository.findById(id);
    }
}
