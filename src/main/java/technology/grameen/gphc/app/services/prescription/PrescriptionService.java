package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.healthapp.entity.prescription.Prescription;

import java.util.Optional;

public interface PrescriptionService {

    void addPrescription(Prescription prescription);

    Optional<?> getById(String id);

    Optional<?> getByCheckup(String id);
}
