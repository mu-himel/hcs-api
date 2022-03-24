package technology.grameen.gphc.app.services.checkup;


import technology.grameen.gphc.app.healthapp.entity.checkup.BasicCheckup;

import java.util.List;
import java.util.Optional;

public interface CheckupService {

    BasicCheckup add(BasicCheckup checkup);

    List<?> getPatientCheckup(String id);
}
