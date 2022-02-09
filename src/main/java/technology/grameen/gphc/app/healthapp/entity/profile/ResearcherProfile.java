package technology.grameen.gphc.app.healthapp.entity.profile;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "researcher_profiles")
public class ResearcherProfile {

    @Id
    private UUID id = UUID.randomUUID();
    private String speciality;
    private String degree;
    private String institute;
    private String designation;
    private String degreeYear;

    @OneToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @Column(length = 1000)
    private String signatureFile;

    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
