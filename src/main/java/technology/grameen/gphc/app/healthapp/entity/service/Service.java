package technology.grameen.gphc.app.healthapp.entity.service;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "services")
public class Service {

    @Id
    private UUID id = UUID.randomUUID();

    private String name;

    private String code;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceCategory serviceCategory;


    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
