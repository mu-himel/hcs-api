package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.healthapp.entity.prescription.Dose;

import java.util.List;

public interface DoseService {

    void addDose(Dose dose);

    List<Dose> getDoses();
}
