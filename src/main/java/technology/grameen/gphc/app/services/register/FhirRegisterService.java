package technology.grameen.gphc.app.services.register;
import technology.grameen.gphc.app.request.fhir.Patient;

import java.util.Optional;

public interface FhirRegisterService {

    Optional<?> getPatientId();

    Optional<?> registerPatient(Patient patient);
}
