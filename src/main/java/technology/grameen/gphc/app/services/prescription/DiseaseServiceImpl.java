package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.prescription.Disease;
import technology.grameen.gphc.app.healthapp.repositories.DiseaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiseaseServiceImpl implements DiseaseService{

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    @Transactional
    public void add(Disease disease) {
        diseaseRepository.save(disease);
    }

    @Override
    public List<Disease> getAll() {
        return diseaseRepository.findAll();
    }

    @Override
    public Optional<?> getById(String id) {
        return diseaseRepository.findById(UUID.fromString(id));
    }
}
