package technology.grameen.gphc.app.healthapp.entity.profile;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.Site;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_profiles")
public class Profile {

    @Id
    private UUID id = UUID.randomUUID();

    private String firstName;
    private String lastName;
    private String bloodGroup;
    private String maritalStatus;

    @Column(length = 1000)
    private String profileImage;
    private String email;
    private String contactNumber;
    private String contactNumber2;
    private String religion;
    private String guardianName;
    private String identityType;
    private String identityValue;

    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;

    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;



}
