package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.prescription.Prescription;
import technology.grameen.gphc.app.healthapp.repositories.PrescriptionRepository;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    @Transactional
    public void addPrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }
}
