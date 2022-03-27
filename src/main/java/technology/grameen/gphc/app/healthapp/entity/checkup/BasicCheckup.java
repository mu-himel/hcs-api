package technology.grameen.gphc.app.healthapp.entity.checkup;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "basic_checkups")
public class BasicCheckup {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    private Double height;
    private Double weight;
    private Double bmi;
    private Double waistMale;
    private Double waistFemale;
    private Double hip;
    private Double waistHipRatioFemale;
    private Double waistHipRatioMale;
    private Double temperature;
    private Double oxygenOfBlood;
    private Double bloodPressureSystolic;
    private Double bloodPressureDiastolic;
    private Double bloodSugar;
    private String bloodSugarType;
    private Double bloodHemoglobin;
    // Urinalysis
    private String urinaryGlucose;
    private String urinaryProtein;
    private String urinaryUrobilinogen;
    private Double urinaryPh;

    private Double pulseRate;
    private String arrhythmia;
    private Double cholesterol;
    private Double uricAcid;
    private String hbsag;
    private String bloodGroup;
    private String isDonor;
    private String smoker;
    private String additionalTest;

    @Column(updatable = false)
    private String createdBy;
    private String updatedBy;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getWaistMale() {
        return waistMale;
    }

    public void setWaistMale(Double waistMale) {
        this.waistMale = waistMale;
    }

    public Double getWaistFemale() {
        return waistFemale;
    }

    public void setWaistFemale(Double waistFemale) {
        this.waistFemale = waistFemale;
    }

    public Double getHip() {
        return hip;
    }

    public void setHip(Double hip) {
        this.hip = hip;
    }

    public Double getWaistHipRatioMale() {
        return waistHipRatioMale;
    }

    public void setWaistHipRatioMale(Double waistHipRatioMale) {
        this.waistHipRatioMale = waistHipRatioMale;
    }

    public Double getWaistHipRatioFemale() {
        return waistHipRatioFemale;
    }

    public void setWaistHipRatioFemale(Double waistHipRatioFemale) {
        this.waistHipRatioFemale = waistHipRatioFemale;
    }



    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getOxygenOfBlood() {
        return oxygenOfBlood;
    }

    public void setOxygenOfBlood(Double oxygenOfBlood) {
        this.oxygenOfBlood = oxygenOfBlood;
    }

    public Double getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(Double bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public Double getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(Double bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public Double getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Double bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public String getBloodSugarType() {
        return bloodSugarType;
    }

    public void setBloodSugarType(String bloodSugarType) {
        this.bloodSugarType = bloodSugarType;
    }

    public Double getBloodHemoglobin() {
        return bloodHemoglobin;
    }

    public void setBloodHemoglobin(Double bloodHemoglobin) {
        this.bloodHemoglobin = bloodHemoglobin;
    }

    public String getUrinaryGlucose() {
        return urinaryGlucose;
    }

    public void setUrinaryGlucose(String urinaryGlucose) {
        this.urinaryGlucose = urinaryGlucose;
    }

    public String getUrinaryProtein() {
        return urinaryProtein;
    }

    public void setUrinaryProtein(String urinaryProtein) {
        this.urinaryProtein = urinaryProtein;
    }

    public String getUrinaryUrobilinogen() {
        return urinaryUrobilinogen;
    }

    public void setUrinaryUrobilinogen(String urinaryUrobilinogen) {
        this.urinaryUrobilinogen = urinaryUrobilinogen;
    }

    public Double getUrinaryPh() {
        return urinaryPh;
    }

    public void setUrinaryPh(Double urinaryPh) {
        this.urinaryPh = urinaryPh;
    }

    public Double getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Double pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getArrhythmia() {
        return arrhythmia;
    }

    public void setArrhythmia(String arrhythmia) {
        this.arrhythmia = arrhythmia;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Double getUricAcid() {
        return uricAcid;
    }

    public void setUricAcid(Double uricAcid) {
        this.uricAcid = uricAcid;
    }

    public String getHbsag() {
        return hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getIsDonor() {
        return isDonor;
    }

    public void setIsDonor(String isDonor) {
        this.isDonor = isDonor;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public String getAdditionalTest() {
        return additionalTest;
    }

    public void setAdditionalTest(String additionalTest) {
        this.additionalTest = additionalTest;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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
}
