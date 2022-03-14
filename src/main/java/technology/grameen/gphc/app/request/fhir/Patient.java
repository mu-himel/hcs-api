package technology.grameen.gphc.app.request.fhir;

import java.util.List;

public class Patient {

    private String resourceType = "Patient";
    private String id;
    private List<NameInfo> name;
    private String email;
    private List<CommonProperty> telecom;
    private String gender;
    private String birthDate;
    private List<TextProperty> address;
    private TextProperty maritalStatus;

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<NameInfo> getName() {
        return name;
    }

    public void setName(List<NameInfo> name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CommonProperty> getTelecom() {
        return telecom;
    }

    public void setTelecom(List<CommonProperty> telecom) {
        this.telecom = telecom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<TextProperty> getAddress() {
        return address;
    }

    public void setAddress(List<TextProperty> address) {
        this.address = address;
    }

    public TextProperty getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(TextProperty maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
}
