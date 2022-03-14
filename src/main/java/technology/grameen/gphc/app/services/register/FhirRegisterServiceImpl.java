package technology.grameen.gphc.app.services.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.component.UrlBuilder;
import technology.grameen.gphc.app.request.fhir.Patient;
import technology.grameen.gphc.app.services.network.NetworkService;

import java.util.Map;
import java.util.Optional;

@Service
public class FhirRegisterServiceImpl implements FhirRegisterService {

    @Autowired
    private NetworkService networkService;

    @Autowired
    private UrlBuilder urlBuilder;

    @Override
    public Optional<?> getPatientId() {
        HttpHeaders headers= new HttpHeaders();
        headers.set("Content-Type","application/json");
        headers.set("Prefer","return=representation");
        HttpEntity<HttpHeaders> payload = new HttpEntity(headers);
        ResponseEntity<?> response =networkService.post(urlBuilder.getEhrEndpoint(), payload, Map.class);

        return Optional.ofNullable(response.getBody());
    }

    @Override
    public Optional<?> registerPatient(Patient patient) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type","application/json");
        HttpEntity<Patient> payload = new HttpEntity(patient,headers);
        ResponseEntity<?> response = networkService.put(urlBuilder.getFhirEndpoint()+"/"+patient.getId(),payload, Map.class);
        if(response.getStatusCode().value() == HttpStatus.CREATED.value()){
            return Optional.ofNullable(patient.getId());
        }
        return Optional.empty();
    }
}
