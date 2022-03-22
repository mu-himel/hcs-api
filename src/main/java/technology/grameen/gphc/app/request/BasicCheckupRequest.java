package technology.grameen.gphc.app.request;

import technology.grameen.gphc.app.healthapp.entity.checkup.BasicCheckup;

import java.util.Map;

public class BasicCheckupRequest {

    private BasicCheckup basicCheckup;

    private Map<String,?> ehr;

    public BasicCheckup getBasicCheckup() {
        return basicCheckup;
    }

    public void setBasicCheckup(BasicCheckup basicCheckup) {
        this.basicCheckup = basicCheckup;
    }

    public Map<String, ?> getEhr() {
        return ehr;
    }

    public void setEhr(Map<String, ?> ehr) {
        this.ehr = ehr;
    }
}
