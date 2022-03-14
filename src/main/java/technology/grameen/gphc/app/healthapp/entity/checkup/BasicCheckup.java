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
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    private Double height;
    private Double weight;
    private Double bmi;
    private Double waist;
    private Double hip;
    private Double waistHipRatio;
    private Double temperature;
    private Double oxygenOfBlood;
    private Double bloodPressureSystolic;
    private Double bloodPressureDiastolic;
    private Double bloodGlucose;
    private String bloodGlucoseType;
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
}
