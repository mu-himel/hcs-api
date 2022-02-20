package technology.grameen.gphc.app.request;


import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean enabled;

    private List<String> realmRoles = new ArrayList<>();
    private List<Credential> credentials = new ArrayList<>();


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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getRealmRoles() {
        return realmRoles;
    }

    public void addRealmRole(String realmRole) {
        this.realmRoles.add(realmRole);
    }

    public List<Credential> getCredentials() {
        return credentials;
    }

    public void addCredential(Credential credential) {
        this.credentials.add(credential);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
