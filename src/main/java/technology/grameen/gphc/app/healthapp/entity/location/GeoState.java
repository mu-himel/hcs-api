package technology.grameen.gphc.app.healthapp.entity.location;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.location.GeoCountry;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "geo_states")
public class GeoState {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private GeoCountry country;

    @Column(length = 2)
    private String countryShortCode;

    @Column(length = 32)
    private String code;

    @Column(length = 128)
    private String name;

    private Integer status;

    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeoCountry getCountry() {
        return country;
    }

    public void setCountry(GeoCountry country) {
        this.country = country;
    }

    public String getCountryShortCode() {
        return countryShortCode;
    }

    public void setCountryShortCode(String countryShortCode) {
        this.countryShortCode = countryShortCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
