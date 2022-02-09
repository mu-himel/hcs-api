package technology.grameen.gphc.app.healthapp.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sites")
public class Site {

    @Id
    private UUID id = UUID.randomUUID();
    private String title;
    private String alias;
    private String description;
    private String address1;
    private String address2;
    private String email;
    private String contactNumber;
    private String longitude;
    private String latitude;
    private String postalCode;

    @Column(length = 1000)
    private String logo;

    private Boolean isShowLogoInPrescription;
    private Boolean isShowSiteHeader;
    private Boolean isHideAllReportHeader;
    private Boolean isAutoBarCodeGenerationEnabled;

    @ManyToOne(fetch = FetchType.LAZY)
    private GeoCountry country;

    @ManyToOne(fetch = FetchType.LAZY)
    private GeoCity city;

    @ManyToOne(fetch = FetchType.LAZY)
    private GeoState state;

    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
