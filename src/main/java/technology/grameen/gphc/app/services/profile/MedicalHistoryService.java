package technology.grameen.gphc.app.services.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.profile.MedicalHistory;

import java.util.Optional;

public interface MedicalHistoryService {

    MedicalHistory addMedicalHistory(MedicalHistory medicalHistory);

    MedicalHistory updateMedicalHistory(MedicalHistory medicalHistory);

    Optional<?> getMedicalHistoryById(String id);

    Page<?> getAll(Pageable pageable);
}
