package technology.grameen.gphc.app.healthapp.entity.doctor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    private UUID id = null;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile doctor;

    private String source;

    private LocalDateTime appointmentDatetime;

    private String type;

    private String problem;
    private String contactNumber;
    private Short serialNo;

    private LocalDateTime slotStartTime;
    private LocalDateTime slotEndTime;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
