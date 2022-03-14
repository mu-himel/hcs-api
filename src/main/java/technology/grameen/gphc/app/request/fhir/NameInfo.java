package technology.grameen.gphc.app.request.fhir;

public class NameInfo {
    private String family;
    private String text;

    public NameInfo(String text, String family) {
        this.text = text;
        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
