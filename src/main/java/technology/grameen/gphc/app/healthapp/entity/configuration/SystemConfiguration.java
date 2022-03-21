package technology.grameen.gphc.app.healthapp.entity.configuration;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.location.GeoCountry;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "config_system")
public class SystemConfiguration {

    @Id
    private UUID id = UUID.randomUUID();
    private String orgName;

    @Column(length = 1000)
    private String logo;

    @ManyToOne(fetch = FetchType.LAZY)
    private GeoCountry country;

    private String identityTypes;

    private Integer noOfIdentityDigit;

    private UUID createdBy;
    private UUID updatedBy;

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public GeoCountry getCountry() {
        return country;
    }

    public void setCountry(GeoCountry country) {
        this.country = country;
    }

    public String getIdentityTypes() {
        return identityTypes;
    }

    public void setIdentityTypes(String identityTypes) {
        this.identityTypes = identityTypes;
    }

    public Integer getNoOfIdentityDigit() {
        return noOfIdentityDigit;
    }

    public void setNoOfIdentityDigit(Integer noOfIdentityDigit) {
        this.noOfIdentityDigit = noOfIdentityDigit;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
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
}
