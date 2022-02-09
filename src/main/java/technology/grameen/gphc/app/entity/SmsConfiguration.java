package technology.grameen.gphc.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

}
