package technology.grameen.gphc.app.healthapp.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Medicine medicine;

    @ManyToOne(fetch = FetchType.LAZY)
    private Advice advice;
    private String otherAdvice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Test test;

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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
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
