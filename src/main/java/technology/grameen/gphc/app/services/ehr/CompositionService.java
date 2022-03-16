package technology.grameen.gphc.app.services.ehr;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CompositionService {

   void addEhr(Map<String,?> composition);

   Optional<?> getAllEhr();

   Optional<?> getEhrByPatient(String patientId);
}
