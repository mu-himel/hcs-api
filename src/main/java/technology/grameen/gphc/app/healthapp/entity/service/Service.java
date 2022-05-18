package technology.grameen.gphc.app.healthapp.entity.service;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "services")
public class Service {

    @Id
    private UUID id = null;

    private String name;

    private String code;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceCategory serviceCategory;

    @ManyToMany
    private Set<SubscriptionPackage> subscriptionPackages = new LinkedHashSet<>();


    private UUID createdBy;
    private UUID updatedBy;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
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

    public Set<SubscriptionPackage> getSubscriptionPackages() {
        return subscriptionPackages;
    }

    public void setSubscriptionPackages(Set<SubscriptionPackage> subscriptionPackages) {
        this.subscriptionPackages = subscriptionPackages;
    }

    public void addPackage(SubscriptionPackage sp) {
        this.subscriptionPackages.add(sp);
    }
}
