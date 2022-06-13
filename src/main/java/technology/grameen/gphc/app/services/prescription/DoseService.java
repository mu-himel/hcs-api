package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.Dose;

import java.util.List;

public interface DoseService {

    void addDose(Dose dose) throws CustomException;

    List<Dose> getDoses();
}
