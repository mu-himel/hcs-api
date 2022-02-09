package technology.grameen.gphc.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "system_configurations")
public class SystemConfiguration {

    @Id
    private UUID id = UUID.randomUUID();
    private String orgName;

    @Column(length = 1000)
    private String logo;


}
