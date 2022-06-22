package technology.grameen.gphc.app.services.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;
import technology.grameen.gphc.app.healthapp.repositories.InvoiceDetailRepository;
import technology.grameen.gphc.app.healthapp.repositories.PatientInvoiceRepository;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientInvoiceServiceImpl implements PatientInvoiceService{

    @Autowired
    PatientInvoiceRepository patientInvoiceRepository;

    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    @Override
    @Transactional
    public void saveInvoice(PatientInvoice patientInvoice) {

        if(patientInvoice.getId() == null){
            patientInvoice.setId(UUID.randomUUID());
        }
        PatientInvoice pn = patientInvoiceRepository.save(patientInvoice);
        if(pn.getCreatedAt()!=null){
            patientInvoice.getDetails().stream().map((detail)->{
                detail.setPatientInvoice(pn);
                return detail;
            }).collect(Collectors.toList());
            invoiceDetailRepository.saveAll(patientInvoice.getDetails());
        }

    }
}
