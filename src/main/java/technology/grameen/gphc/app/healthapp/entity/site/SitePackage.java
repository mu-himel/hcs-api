package technology.grameen.gphc.app.healthapp.entity.site;

import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "site_packages")
public class SitePackage {

    @Id
    private UUID id =  UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubscriptionPackage subscriptionPackage;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal totalAmount;
    private BigDecimal discountedAmount;

    private Integer maxMemberLimit;

    private String code;
    private String status;
    private String paymentStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public SubscriptionPackage getSubscriptionPackage() {
        return subscriptionPackage;
    }

    public void setSubscriptionPackage(SubscriptionPackage subscriptionPackage) {
        this.subscriptionPackage = subscriptionPackage;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(BigDecimal discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public Integer getMaxMemberLimit() {
        return maxMemberLimit;
    }

    public void setMaxMemberLimit(Integer maxMemberLimit) {
        this.maxMemberLimit = maxMemberLimit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
