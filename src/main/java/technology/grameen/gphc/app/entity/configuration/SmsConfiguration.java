package technology.grameen.gphc.app.entity.configuration;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sms_configurations")
public class SmsConfiguration {

    @Id
    private UUID id = UUID.randomUUID();
    private String url;
    private String apiKey;
    private String apiSecret;
    private Boolean isActive;

    private UUID createdBy;
    private UUID updatedBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
