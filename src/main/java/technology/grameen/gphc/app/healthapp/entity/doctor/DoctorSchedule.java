package technology.grameen.gphc.app.healthapp.entity.doctor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "doctor_schedules")
public class DoctorSchedule {

    @Id
    private UUID id = null;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile doctor;

    private LocalDateTime slotStartTime;
    private LocalDateTime slotEndTime;
    private Short maximumPatientLimit;
    private Boolean isRecurring;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Profile getDoctor() {
        return doctor;
    }

    public void setDoctor(Profile doctor) {
        this.doctor = doctor;
    }

    public Short getMaximumPatientLimit() {
        return maximumPatientLimit;
    }

    public void setMaximumPatientLimit(Short maximumPatientLimit) {
        this.maximumPatientLimit = maximumPatientLimit;
    }

    public Boolean getRecurring() {
        return isRecurring;
    }

    public void setRecurring(Boolean recurring) {
        isRecurring = recurring;
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

    public LocalDateTime getSlotStartTime() {
        return slotStartTime;
    }

    public void setSlotStartTime(LocalDateTime slotStartTime) {
        this.slotStartTime = slotStartTime;
    }

    public LocalDateTime getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(LocalDateTime slotEndTime) {
        this.slotEndTime = slotEndTime;
    }
}
