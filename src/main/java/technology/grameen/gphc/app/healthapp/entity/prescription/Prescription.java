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

    @OneToMany
    private List<ChiefComplaint> chiefComplaints;
    private String otherChiefComplaint;

    @OneToMany
    private List<Disease> diseases;

    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionMedicine> medicines;

    @OneToMany
    private List<Advice> advices;

    private String otherAdvice;

    @OneToMany
    private List<Hospital> hospitals;

    private String  doctor;

    @OneToMany
    private List<Service> services;

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

    public List<ChiefComplaint> getChiefComplaints() {
        return chiefComplaints;
    }

    public void setChiefComplaints(List<ChiefComplaint> chiefComplaints) {
        this.chiefComplaints = chiefComplaints;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public List<Advice> getAdvices() {
        return advices;
    }

    public void setAdvices(List<Advice> advices) {
        this.advices = advices;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public BasicCheckup getBasicCheckup() {
        return basicCheckup;
    }

    public void setBasicCheckup(BasicCheckup basicCheckup) {
        this.basicCheckup = basicCheckup;
    }
}
