package technology.grameen.gphc.app.healthapp.entity.configuration;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "config_system")
public class SystemConfiguration {

    @Id
    private UUID id = UUID.randomUUID();
    private String orgName;

    @Column(length = 1000)
    private String logo;

    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
