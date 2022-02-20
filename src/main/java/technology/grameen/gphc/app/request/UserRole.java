package technology.grameen.gphc.app.request;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserRole implements Serializable {

    private String userId;

    private List<Map<String,String>> roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Map<String,String>> getRoles() {
        return roles;
    }

    public void setRoles(List<Map<String,String>> roles) {
        this.roles = roles;
    }
}
