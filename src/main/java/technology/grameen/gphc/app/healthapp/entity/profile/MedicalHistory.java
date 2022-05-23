package technology.grameen.gphc.app.healthapp.entity.profile;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "medical_histories")
public class MedicalHistory {

    @Id
    private UUID id = UUID.randomUUID();

    private Boolean isFirstVisit;

    private String elapsedTimeFromLastMeal;

    private Boolean anySymptom;

    private String symptomDetail;

    private Boolean takingMedicineForFollowingDisease;

    private Boolean hasBloodPressure;
    private String medicineForBloodPressure;

    private Boolean hasDiabetic;
    private String medicineForDiabetic;

    private Boolean hasCholesterol;
    private String medicineForCholesterol;

    private String hypertensiveSufferingDuration;
    private String diabeticSufferingDuration;
    private String cholesterolSufferingDuration;

    private Short anyFamilyMemberSuffering;

    private Boolean everDiagnosedAnemicByDoctor;

    private Boolean regularSmoker;

    private Boolean haveAnyDrugAllergy;

    private String allergicDrugName;

    private Boolean everHadAnyOperation;

    private String operationName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getFirstVisit() {
        return isFirstVisit;
    }

    public void setFirstVisit(Boolean firstVisit) {
        isFirstVisit = firstVisit;
    }

    public String getElapsedTimeFromLastMeal() {
        return elapsedTimeFromLastMeal;
    }

    public void setElapsedTimeFromLastMeal(String elapsedTimeFromLastMeal) {
        this.elapsedTimeFromLastMeal = elapsedTimeFromLastMeal;
    }

    public Boolean getAnySymptom() {
        return anySymptom;
    }

    public void setAnySymptom(Boolean anySymptom) {
        this.anySymptom = anySymptom;
    }

    public String getSymptomDetail() {
        return symptomDetail;
    }

    public void setSymptomDetail(String symptomDetail) {
        this.symptomDetail = symptomDetail;
    }

    public Boolean getTakingMedicineForFollowingDisease() {
        return takingMedicineForFollowingDisease;
    }

    public void setTakingMedicineForFollowingDisease(Boolean takingMedicineForFollowingDisease) {
        this.takingMedicineForFollowingDisease = takingMedicineForFollowingDisease;
    }

    public Boolean getHasBloodPressure() {
        return hasBloodPressure;
    }

    public void setHasBloodPressure(Boolean hasBloodPressure) {
        this.hasBloodPressure = hasBloodPressure;
    }

    public String getMedicineForBloodPressure() {
        return medicineForBloodPressure;
    }

    public void setMedicineForBloodPressure(String medicineForBloodPressure) {
        this.medicineForBloodPressure = medicineForBloodPressure;
    }

    public Boolean getHasDiabetic() {
        return hasDiabetic;
    }

    public void setHasDiabetic(Boolean hasDiabetic) {
        this.hasDiabetic = hasDiabetic;
    }

    public String getMedicineForDiabetic() {
        return medicineForDiabetic;
    }

    public void setMedicineForDiabetic(String medicineForDiabetic) {
        this.medicineForDiabetic = medicineForDiabetic;
    }

    public Boolean getHasCholesterol() {
        return hasCholesterol;
    }

    public void setHasCholesterol(Boolean hasCholesterol) {
        this.hasCholesterol = hasCholesterol;
    }

    public String getMedicineForCholesterol() {
        return medicineForCholesterol;
    }

    public void setMedicineForCholesterol(String medicineForCholesterol) {
        this.medicineForCholesterol = medicineForCholesterol;
    }

    public String getHypertensiveSufferingDuration() {
        return hypertensiveSufferingDuration;
    }

    public void setHypertensiveSufferingDuration(String hypertensiveSufferingDuration) {
        this.hypertensiveSufferingDuration = hypertensiveSufferingDuration;
    }

    public String getDiabeticSufferingDuration() {
        return diabeticSufferingDuration;
    }

    public void setDiabeticSufferingDuration(String diabeticSufferingDuration) {
        this.diabeticSufferingDuration = diabeticSufferingDuration;
    }

    public String getCholesterolSufferingDuration() {
        return cholesterolSufferingDuration;
    }

    public void setCholesterolSufferingDuration(String cholesterolSufferingDuration) {
        this.cholesterolSufferingDuration = cholesterolSufferingDuration;
    }

    public Short getAnyFamilyMemberSuffering() {
        return anyFamilyMemberSuffering;
    }

    public void setAnyFamilyMemberSuffering(Short anyFamilyMemberSuffering) {
        this.anyFamilyMemberSuffering = anyFamilyMemberSuffering;
    }

    public Boolean getEverDiagnosedAnemicByDoctor() {
        return everDiagnosedAnemicByDoctor;
    }

    public void setEverDiagnosedAnemicByDoctor(Boolean everDiagnosedAnemicByDoctor) {
        this.everDiagnosedAnemicByDoctor = everDiagnosedAnemicByDoctor;
    }

    public Boolean getRegularSmoker() {
        return regularSmoker;
    }

    public void setRegularSmoker(Boolean regularSmoker) {
        this.regularSmoker = regularSmoker;
    }

    public Boolean getHaveAnyDrugAllergy() {
        return haveAnyDrugAllergy;
    }

    public void setHaveAnyDrugAllergy(Boolean haveAnyDrugAllergy) {
        this.haveAnyDrugAllergy = haveAnyDrugAllergy;
    }

    public String getAllergicDrugName() {
        return allergicDrugName;
    }

    public void setAllergicDrugName(String allergicDrugName) {
        this.allergicDrugName = allergicDrugName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Boolean getEverHadAnyOperation() {
        return everHadAnyOperation;
    }

    public void setEverHadAnyOperation(Boolean everHadAnyOperation) {
        this.everHadAnyOperation = everHadAnyOperation;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
