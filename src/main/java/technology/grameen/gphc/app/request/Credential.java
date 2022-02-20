package technology.grameen.gphc.app.request;

public class Credential {

    private String value;
    private Boolean temporary = false;

    public Credential(){}

    public Credential(String value, Boolean temporary) {
        this.value = value;
        this.temporary = temporary;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getTemporary() {
        return temporary;
    }

    public void setTemporary(Boolean temporary) {
        this.temporary = temporary;
    }
}
