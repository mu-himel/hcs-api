package technology.grameen.gphc.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "site_users")
public class SiteUser {

    @Id
    private UUID id = UUID.randomUUID();
    private UUID userId;
    private Boolean status;


}
