package technology.grameen.gphc.app.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

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



}
