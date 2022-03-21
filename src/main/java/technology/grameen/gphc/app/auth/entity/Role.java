package technology.grameen.gphc.app.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "keycloak_role")
public class Role {

    @Id
    private String id;

    @ManyToMany(mappedBy = "role")
    private Set<User> user;
}
