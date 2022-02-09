package technology.grameen.gphc.app.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profile_additional_infos")
public class ProfileAdditionalInfo {

    @Id
    private UUID id = UUID.randomUUID();
    private String bmaRegNo;
    private String speciality;
    private String degree;
    private String hospital;
    private String designation;

    @OneToOne(fetch = FetchType.LAZY)
    private UserProfile profile;

    @Column(length = 1000)
    private String signatureFile;
}
