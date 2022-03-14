package technology.grameen.gphc.app.request.fhir;

public class TextProperty {
    private String text;

    public TextProperty(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
