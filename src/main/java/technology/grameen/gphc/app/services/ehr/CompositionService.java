package technology.grameen.gphc.app.services.ehr;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CompositionService {

   Optional<?> addEhr(Map<String,?> composition, String patientId);

   Optional<?> getAllEhr();

   Optional<?> getEhrByPatient(String patientId);
}
