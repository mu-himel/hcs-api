package technology.grameen.gphc.app.services.ehr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.component.UrlBuilder;
import technology.grameen.gphc.app.services.network.NetworkService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CompositionServiceImpl implements CompositionService{

    @Autowired
    private UrlBuilder urlBuilder;

    @Autowired
    private NetworkService networkService;

    @Override
    public Optional<?> addEhr(Map<String, ?> composition,String patientId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Map<String,?>> payload = new HttpEntity<>(composition,headers);
        String url = urlBuilder.getEhrCompositionEndpoint() + "?format=FLAT&templateId=NCD.v0&ehrId="+patientId;
        ResponseEntity<?> response = networkService.post(url,payload,Map.class);
        HttpStatus status = response.getStatusCode();
        return Optional.ofNullable(response.getBody());
    }

    @Override
    public Optional<?> getAllEhr() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<?> payload = new HttpEntity<>(headers);
        ResponseEntity<?> response = networkService.get(urlBuilder.getEhrCompositionEndpoint(),payload,Map.class);
        return Optional.ofNullable(response.getBody());
    }

    @Override
    public Optional<?> getEhrByPatient(String patientId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        Map<String,String> query = new HashMap<>();
        String q = getQuerySting(patientId);
        query.put("q",q);
        HttpEntity<Map<String,String>> payload = new HttpEntity<>(query,headers);
        String url = urlBuilder.getEhrQueryEndPoint();
        ResponseEntity<?> response = networkService.post(url, payload,Map.class);
        return Optional.ofNullable(response.getBody());
    }

    private String getQuerySting(String patientId){
        return "SELECT c/content[openEHR-EHR-OBSERVATION.height.v2], " +
                "c/content[openEHR-EHR-OBSERVATION.body_weight.v2], " +
                "c/content[openEHR-EHR-OBSERVATION.body_mass_index.v2], " +
                "c/content[openEHR-EHR-OBSERVATION.waist_circumference.v1], " +
                "c/content[openEHR-EHR-OBSERVATION.hip_circumference.v1], " +
                "c/content[openEHR-EHR-OBSERVATION.waist_hip_ratio.v0], " +
                "c/content[openEHR-EHR-OBSERVATION.body_temperature.v2], " +
                "c/content[openEHR-EHR-OBSERVATION.pulse_oximetry.v1], " +
                "c/content[openEHR-EHR-OBSERVATION.blood_pressure.v2], " +
                "c/content[openEHR-EHR-OBSERVATION.pulse.v2], " +
                "c/content[openEHR-EHR-OBSERVATION.laboratory_test_result.v1],  " +
                "c/content[openEHR-EHR-OBSERVATION.urinalysis.v1], " +
                "c/content[openEHR-EHR-EVALUATION.tobacco_smoking_summary.v1] FROM EHR e " +
                "CONTAINS COMPOSITION c [openEHR-EHR-COMPOSITION.encounter.v1] " +
                "WHERE e/ehr_id/value='"+patientId+"'";
    }


}
