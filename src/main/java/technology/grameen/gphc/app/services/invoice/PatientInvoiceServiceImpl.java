package technology.grameen.gphc.app.services.invoice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;
import technology.grameen.gphc.app.healthapp.repositories.PatientInvoiceRepository;

import java.util.UUID;

@Service
public class PatientInvoiceServiceImpl implements PatientInvoiceService{

    PatientInvoiceRepository patientInvoiceRepository;

    @Override
    @Transactional
    public void saveInvoice(PatientInvoice patientInvoice) {

        if(patientInvoice.getId() == null){
            patientInvoice.setId(UUID.randomUUID());
        }
        patientInvoiceRepository.save(patientInvoice);
    }
}
