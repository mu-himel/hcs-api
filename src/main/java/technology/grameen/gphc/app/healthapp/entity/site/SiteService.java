package technology.grameen.gphc.app.healthapp.entity.site;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.service.Service;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "site_services")
public class SiteService {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;

    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    private BigDecimal price;
    private BigDecimal revisitPrice;

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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRevisitPrice() {
        return revisitPrice;
    }

    public void setRevisitPrice(BigDecimal revisitPrice) {
        this.revisitPrice = revisitPrice;
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
