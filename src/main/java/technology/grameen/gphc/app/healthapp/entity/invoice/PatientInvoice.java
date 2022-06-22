package technology.grameen.gphc.app.healthapp.entity.invoice;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "patient_invoices")
public class PatientInvoice {

    @Id
    private UUID id = null;

    private String invoiceNumber;

    @ManyToOne
    private Profile patient;

    private String subscriptionCode;
    private String patientType;
    private Boolean isPosted = false;
    private BigDecimal serviceAmount;
    private BigDecimal discountAmount;
    private BigDecimal paidAmount;
    private String createdBy;

    @OneToMany(mappedBy = "patientInvoice")
    @OrderBy("id ASC")
    private Set<InvoiceDetail> details;

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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Profile getPatient() {
        return patient;
    }

    public void setPatient(Profile patient) {
        this.patient = patient;
    }

    public String getSubscriptionCode() {
        return subscriptionCode;
    }

    public void setSubscriptionCode(String subscriptionCode) {
        this.subscriptionCode = subscriptionCode;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public Boolean getPosted() {
        return isPosted;
    }

    public void setPosted(Boolean posted) {
        isPosted = posted;
    }

    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public Set<InvoiceDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<InvoiceDetail> details) {
        this.details = details;
    }
}
