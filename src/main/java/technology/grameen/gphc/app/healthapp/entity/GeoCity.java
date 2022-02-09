package technology.grameen.gphc.app.healthapp.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "geo_cities")
public class GeoCity {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private GeoCountry country;

    @Column(length = 11)
    private String countryShortCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private GeoState state;

    private Integer cityNumber;

    private String name;

    private Double latitude;
    private Double longitude;
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

    public GeoState getState() {
        return state;
    }

    public void setState(GeoState state) {
        this.state = state;
    }

    public Integer getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(Integer cityNumber) {
        this.cityNumber = cityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
