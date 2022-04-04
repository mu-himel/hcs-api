package technology.grameen.gphc.app.healthapp.entity.prescription;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.checkup.BasicCheckup;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.service.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile patient;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionChiefComplaint> chiefComplaints;
    private String otherChiefComplaint;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionDisease> diseases;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionMedicine> medicines;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionAdvice> advices;

    private String otherAdvice;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionHospital> hospitals;

    private String  doctor;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionService> services;

    @OneToOne
    private BasicCheckup basicCheckup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private String createdBy;
    private String updatedBy;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Profile getPatient() {
        return patient;
    }

    public void setPatient(Profile patient) {
        this.patient = patient;
    }

    public String getOtherChiefComplaint() {
        return otherChiefComplaint;
    }

    public void setOtherChiefComplaint(String otherChiefComplaint) {
        this.otherChiefComplaint = otherChiefComplaint;
    }

    public String getOtherAdvice() {
        return otherAdvice;
    }

    public void setOtherAdvice(String otherAdvice) {
        this.otherAdvice = otherAdvice;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PrescriptionMedicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<PrescriptionMedicine> medicines) {
        this.medicines = medicines;
    }

    public List<PrescriptionChiefComplaint> getChiefComplaints() {
        return chiefComplaints;
    }

    public void setChiefComplaints(List<PrescriptionChiefComplaint> chiefComplaints) {
        this.chiefComplaints = chiefComplaints;
    }


    public List<PrescriptionDisease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<PrescriptionDisease> diseases) {
        this.diseases = diseases;
    }

    public List<PrescriptionAdvice> getAdvices() {
        return advices;
    }

    public void setAdvices(List<PrescriptionAdvice> advices) {
        this.advices = advices;
    }

    public List<PrescriptionHospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<PrescriptionHospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<PrescriptionService> getServices() {
        return services;
    }

    public void setServices(List<PrescriptionService> services) {
        this.services = services;
    }

    public BasicCheckup getBasicCheckup() {
        return basicCheckup;
    }

    public void setBasicCheckup(BasicCheckup basicCheckup) {
        this.basicCheckup = basicCheckup;
    }
}
