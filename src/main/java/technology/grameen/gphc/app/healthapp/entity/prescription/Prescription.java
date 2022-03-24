package technology.grameen.gphc.app.healthapp.entity.prescription;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;
import technology.grameen.gphc.app.healthapp.entity.prescription.Advice;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;
import technology.grameen.gphc.app.healthapp.entity.prescription.Disease;
import technology.grameen.gphc.app.healthapp.entity.prescription.Test;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChiefComplaint chiefCompliant;
    private String otherChiefCompliant;

    @ManyToOne(fetch = FetchType.LAZY)
    private Disease disease;

    @OneToMany
    private List<Medicine> medicines;

    @ManyToOne(fetch = FetchType.LAZY)
    private Advice advice;
    private String otherAdvice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile doctor;

    @OneToMany
    private List<Test> test;

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

    public ChiefComplaint getChiefCompliant() {
        return chiefCompliant;
    }

    public void setChiefCompliant(ChiefComplaint chiefCompliant) {
        this.chiefCompliant = chiefCompliant;
    }

    public String getOtherChiefCompliant() {
        return otherChiefCompliant;
    }

    public void setOtherChiefCompliant(String otherChiefCompliant) {
        this.otherChiefCompliant = otherChiefCompliant;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }



    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getOtherAdvice() {
        return otherAdvice;
    }

    public void setOtherAdvice(String otherAdvice) {
        this.otherAdvice = otherAdvice;
    }

    public Profile getDoctor() {
        return doctor;
    }

    public void setDoctor(Profile doctor) {
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
}
