package technology.grameen.gphc.app.services.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.profile.MedicalHistory;
import technology.grameen.gphc.app.healthapp.repositories.MedicalHistoryRepository;

import java.util.Optional;

public interface MedicalHistoryService {

    MedicalHistory addMedicalHistory(MedicalHistory medicalHistory);

    void updateMedicalHistory(String id, MedicalHistory medicalHistory);

    Optional<MedicalHistoryRepository.MedicalHistoryInfo> getMedicalHistoryById(String id);

    Page<?> getAll(String id, Pageable pageable);
}
