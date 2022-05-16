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
        Optional<MedicalHistory> medicalHistoryOp = getMedicalHistoryById(id);
        if(medicalHistoryOp.isPresent()){
            MedicalHistory medicalHistory1 = medicalHistoryOp.get();
            medicalHistory1.setAllergicDrugName(medicalHistory.getAllergicDrugName());
            medicalHistory1.setAnyFamilyMemberSuffering(medicalHistory.getAnyFamilyMemberSuffering());
            medicalHistory1.setAnySymptom(medicalHistory.getAnySymptom());
            medicalHistory1.setCholesterolSufferingDuration(medicalHistory.getCholesterolSufferingDuration());
            medicalHistory1.setDiabeticSufferingDuration(medicalHistory.getDiabeticSufferingDuration());
            medicalHistory1.setElapsedTimeFromLastMeal(medicalHistory.getElapsedTimeFromLastMeal());
            medicalHistory1.setEverDiagnosedAnemicByDoctor(medicalHistory.getEverDiagnosedAnemicByDoctor());
            medicalHistory1.setFirstVisit(medicalHistory.getFirstVisit());
            medicalHistory1.setHasBloodPressure(medicalHistory.getHasBloodPressure());
            medicalHistory1.setHasCholesterol(medicalHistory.getHasCholesterol());
            medicalHistory1.setHasDiabetic(medicalHistory.getHasDiabetic());
            medicalHistory1.setHaveAnyDrugAllergy(medicalHistory.getHaveAnyDrugAllergy());
            medicalHistory1.setHypertensiveSufferingDuration(medicalHistory.getHypertensiveSufferingDuration());
            medicalHistory1.setMedicineForBloodPressure(medicalHistory.getMedicineForBloodPressure());
            medicalHistory1.setMedicineForCholesterol(medicalHistory.getMedicineForCholesterol());
            medicalHistory1.setMedicineForDiabetic(medicalHistory.getMedicineForDiabetic());
            medicalHistory1.setRegularSmoker(medicalHistory.getRegularSmoker());
            medicalHistory1.setSymptomDetail(medicalHistory.getSymptomDetail());
            medicalHistory1.setTakingMedicineForFollowingDisease(medicalHistory.getTakingMedicineForFollowingDisease());
        }
    }

    @Override
    public Optional<MedicalHistory> getMedicalHistoryById(String id) {
        return medicalHistoryRepository.findById(UUID.fromString(id));
    }

    @Override
    public Page<?> getAll(Pageable pageable) {
        return medicalHistoryRepository.findAll(pageable);
    }
}
