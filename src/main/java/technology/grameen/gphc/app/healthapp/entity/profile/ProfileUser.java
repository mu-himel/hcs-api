package technology.grameen.gphc.app.healthapp.entity.profile;

import technology.grameen.gphc.app.auth.entity.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "profile_user")
public class ProfileUser implements Serializable {


    @Id
    private UUID id = UUID.randomUUID();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id",unique = true)
    private Profile profile;

    @Column(unique = true,nullable = false)
    private String userId;

    @Column(unique = true)
    private String username;


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
