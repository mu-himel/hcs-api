package technology.grameen.gphc.app.services.ehr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.component.UrlBuilder;
import technology.grameen.gphc.app.services.network.NetworkService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompositionServiceImpl implements CompositionService{

    @Autowired
    private UrlBuilder urlBuilder;

    @Autowired
    private NetworkService networkService;

    @Override
    public void addEhr(Map<String, ?> composition) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Map<String,?>> payload = new HttpEntity<>(composition,headers);
        ResponseEntity<?> response = networkService.post(urlBuilder.getEhrCompositionEndpoint(),payload,Map.class);
        HttpStatus status = response.getStatusCode();
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
        HttpEntity<?> payload = new HttpEntity<>(headers);
        ResponseEntity<?> response = networkService.get(urlBuilder.getEhrCompositionEndpoint()+"/"+patientId,
                    payload,Map.class);
        return Optional.ofNullable(response.getBody());
    }
}
