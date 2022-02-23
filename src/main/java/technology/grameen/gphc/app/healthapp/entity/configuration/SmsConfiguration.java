package technology.grameen.gphc.app.healthapp.entity.configuration;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "config_sms")
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
