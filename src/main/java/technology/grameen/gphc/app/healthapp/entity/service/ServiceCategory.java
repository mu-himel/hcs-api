package technology.grameen.gphc.app.healthapp.entity.service;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "service_categories")
public class ServiceCategory {

    @Id
    private UUID id = UUID.randomUUID();

    private String code;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceCategory parent;

    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
