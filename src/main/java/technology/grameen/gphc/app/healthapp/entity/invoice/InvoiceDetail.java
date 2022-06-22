package technology.grameen.gphc.app.healthapp.entity.invoice;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.service.Service;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {

    @Id
    private UUID id = null;

    private Boolean isRefunded;

    private BigDecimal serviceAmount;
    private BigDecimal discountAmount;
    private BigDecimal paidAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    private PatientInvoice patientInvoice;

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

    public Boolean getRefunded() {
        return isRefunded;
    }

    public void setRefunded(Boolean refunded) {
        isRefunded = refunded;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public PatientInvoice getPatientInvoice() {
        return patientInvoice;
    }

    public void setPatientInvoice(PatientInvoice patientInvoice) {
        this.patientInvoice = patientInvoice;
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
