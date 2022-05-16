package technology.grameen.gphc.app.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.profile.MedicalHistory;
import technology.grameen.gphc.app.healthapp.repositories.MedicalHistoryRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService{

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    @Transactional
    public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    @Transactional
    public MedicalHistory updateMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public Optional<?> getMedicalHistoryById(String id) {
        return medicalHistoryRepository.findById(UUID.fromString(id));
    }

    @Override
    public Page<?> getAll(Pageable pageable) {
        return medicalHistoryRepository.findAll(pageable);
    }
}
