package technology.grameen.gphc.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "email_configurations")
public class EmailConfiguration {

    @Id
    private UUID id = UUID.randomUUID();
    private String smtpHost;
    private String smtpPort;
    private String fromEmailAddress;
    private String replyTo;
    private Boolean enableSSL;
    private Boolean isActive;
}
