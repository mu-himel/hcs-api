package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.prescription.Prescription;
import technology.grameen.gphc.app.healthapp.repositories.*;

import java.util.Optional;
import java.util.UUID;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PrescriptionMedicineRepository prescriptionMedicineRepository;

    @Autowired
    private PrescriptionChiefComplaintRepository prescriptionChiefComplaintRepository;

    @Autowired
    private PrescriptionAdviceRepository prescriptionAdviceRepository;

    @Autowired
    private PrescriptionHospitalRepository prescriptionHospitalRepository;

    @Autowired
    private PrescriptionDiseaseRepository prescriptionDiseaseRepository;

    @Autowired
    private PrescriptionServiceRepository prescriptionServiceRepository;

    @Override
    @Transactional
    public void addPrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
        if(prescription.getChiefComplaints().size()>0){
            prescription.getChiefComplaints().forEach((cc)->{
                cc.setId(UUID.randomUUID());
                cc.setPrescription(prescription);
                prescriptionChiefComplaintRepository.save(cc);
            });
        }
        if(prescription.getAdvices().size()>0){
            prescription.getAdvices().forEach((advice)->{
                advice.setId(UUID.randomUUID());
                advice.setPrescription(prescription);
                prescriptionAdviceRepository.save(advice);
            });
        }
        if(prescription.getMedicines().size()>0){
            prescription.getMedicines().forEach((medicine)->{
                medicine.setId(UUID.randomUUID());
                medicine.setPrescription(prescription);
                prescriptionMedicineRepository.save(medicine);
            });
        }
        if(prescription.getDiseases().size()>0){
            prescription.getDiseases().forEach((disease)->{
                disease.setId(UUID.randomUUID());
                disease.setPrescription(prescription);
                prescriptionDiseaseRepository.save(disease);
            });
        }
        if(prescription.getHospitals()!=null && prescription.getHospitals().size()>0){
            prescription.getHospitals().forEach((hospital)->{
                hospital.setId(UUID.randomUUID());
                hospital.setPrescription(prescription);
                prescriptionHospitalRepository.save(hospital);
            });
        }
        if(prescription.getServices().size()>0){
            prescription.getServices().forEach((service)->{
                service.setId(UUID.randomUUID());
                service.setPrescription(prescription);
                prescriptionServiceRepository.save(service);
            });
        }
    }

    @Override
    public Optional<?> getById(String id) {
        return prescriptionRepository.findPrescriptionById(UUID.fromString(id));
    }
}
