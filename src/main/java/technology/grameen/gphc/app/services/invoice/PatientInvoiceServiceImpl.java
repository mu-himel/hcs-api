package technology.grameen.gphc.app.services.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.repositories.InvoiceDetailRepository;
import technology.grameen.gphc.app.healthapp.repositories.PatientInvoiceRepository;
import technology.grameen.gphc.app.services.security.OtpService;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientInvoiceServiceImpl implements PatientInvoiceService{

    @Autowired
    PatientInvoiceRepository patientInvoiceRepository;

    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    OtpService otpService;

    @Override
    @Transactional
    public void saveInvoice(PatientInvoice patientInvoice) {

        if(patientInvoice.getId() == null){
            patientInvoice.setId(UUID.randomUUID());
            patientInvoice.setInvoiceNumber("INV"+otpService.generateOtpToken(6));
        }
        PatientInvoice pn = patientInvoiceRepository.save(patientInvoice);
        if(pn.getCreatedAt()!=null){
            patientInvoice.getDetails().stream().map((detail)->{
                detail.setId(UUID.randomUUID());
                detail.setPatientInvoice(pn);
                return detail;
            }).collect(Collectors.toList());
            invoiceDetailRepository.saveAll(patientInvoice.getDetails());
        }

    }

    @Override
    public Page<?> getAll(Pageable pageable) {
        return patientInvoiceRepository.findAllPatientInvoice(pageable);
    }

    @Override
    public Page<?> getAll(Profile patient, Pageable pageable) {
        return patientInvoiceRepository.findAllPatientInvoice(patient,pageable);
    }
}
