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
    public void updateMedicalHistory(String id, MedicalHistory medicalHistory) {
        Optional<MedicalHistoryRepository.MedicalHistoryInfo> medicalHistoryOp = getMedicalHistoryById(id);
        if(medicalHistoryOp.isPresent()){
            MedicalHistoryRepository.MedicalHistoryInfo medicalHistory1 = medicalHistoryOp.get();
            medicalHistory.setId(medicalHistory1.getId());
            medicalHistory.setCreatedAt(medicalHistory1.getCreatedAt());
            medicalHistoryRepository.save(medicalHistory);
        }
    }

    @Override
    public Optional<MedicalHistoryRepository.MedicalHistoryInfo> getMedicalHistoryById(String id) {
        return medicalHistoryRepository.findMedicalHistoryById(UUID.fromString(id));
    }

    @Override
    public Page<?> getAll(String id, Pageable pageable) {
        return medicalHistoryRepository.findAllByProfile(UUID.fromString(id),pageable);
    }
}
