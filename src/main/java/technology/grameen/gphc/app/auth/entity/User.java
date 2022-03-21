package technology.grameen.gphc.app.auth.entity;

import org.hibernate.annotations.DynamicUpdate;
import technology.grameen.gphc.app.request.Credential;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_entity")
public class User {

    @Id
    private String id;
    @Column(updatable = false)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @Column(updatable = false)
    private Boolean enabled;

    @ManyToMany
    @JoinTable(name ="user_role_mapping", joinColumns = {
            @JoinColumn(name = "user_id")
    },inverseJoinColumns = { @JoinColumn(name = "role_id")})
    private Set<Role> role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
