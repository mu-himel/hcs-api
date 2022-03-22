package technology.grameen.gphc.app.healthapp.entity.site;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.location.GeoCity;
import technology.grameen.gphc.app.healthapp.entity.location.GeoCountry;
import technology.grameen.gphc.app.healthapp.entity.location.GeoState;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@DynamicUpdate
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
    private String timeZone;

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
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Boolean getShowLogoInPrescription() {
        return isShowLogoInPrescription;
    }

    public void setShowLogoInPrescription(Boolean showLogoInPrescription) {
        isShowLogoInPrescription = showLogoInPrescription;
    }

    public Boolean getShowSiteHeader() {
        return isShowSiteHeader;
    }

    public void setShowSiteHeader(Boolean showSiteHeader) {
        isShowSiteHeader = showSiteHeader;
    }

    public Boolean getHideAllReportHeader() {
        return isHideAllReportHeader;
    }

    public void setHideAllReportHeader(Boolean hideAllReportHeader) {
        isHideAllReportHeader = hideAllReportHeader;
    }

    public Boolean getAutoBarCodeGenerationEnabled() {
        return isAutoBarCodeGenerationEnabled;
    }

    public void setAutoBarCodeGenerationEnabled(Boolean autoBarCodeGenerationEnabled) {
        isAutoBarCodeGenerationEnabled = autoBarCodeGenerationEnabled;
    }

    public GeoCountry getCountry() {
        return country;
    }

    public void setCountry(GeoCountry country) {
        this.country = country;
    }

    public GeoCity getCity() {
        return city;
    }

    public void setCity(GeoCity city) {
        this.city = city;
    }

    public GeoState getState() {
        return state;
    }

    public void setState(GeoState state) {
        this.state = state;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
