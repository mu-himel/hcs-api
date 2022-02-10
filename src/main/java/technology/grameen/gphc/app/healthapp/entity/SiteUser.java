package technology.grameen.gphc.app.healthapp.entity;

import technology.grameen.gphc.app.auth.entity.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "site_users")
public class SiteUser {

    @Id
    private UUID id = UUID.randomUUID();
    private String userId;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;


}
