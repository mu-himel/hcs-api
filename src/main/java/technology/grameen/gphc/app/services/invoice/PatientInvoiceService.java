package technology.grameen.gphc.app.services.invoice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import java.util.Optional;
import java.util.UUID;

public interface PatientInvoiceService {

    void saveInvoice(PatientInvoice patientInvoice);

    Page<?> getAll(Pageable pageable);

    Page<?> getAll(Profile patient, Pageable pageable);

    Optional<?> getById(UUID id);
}
