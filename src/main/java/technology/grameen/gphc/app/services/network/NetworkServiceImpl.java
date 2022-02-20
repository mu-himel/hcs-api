package technology.grameen.gphc.app.services.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NetworkServiceImpl implements NetworkService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseEntity<?> get(String url, HttpEntity<?> payload, Class<?> c) {

        ResponseEntity<?> entity = restTemplate.exchange(url, HttpMethod.GET, payload, c);
        return entity;
    }

    @Override
    public ResponseEntity<?> post(String url, HttpEntity<?> payload, Class<?> c) {
        ResponseEntity<?> entity = restTemplate.exchange(url,HttpMethod.POST,payload,c);
        return entity;
    }

    @Override
    public ResponseEntity<?> put(String url, HttpEntity<?> payload, Class<?> c) {
        ResponseEntity<?> entity = restTemplate.exchange(url,HttpMethod.PUT,payload,c);
        return entity;
    }

    @Override
    public ResponseEntity<?> delete(String url, HttpEntity<?> payload, Class<?> c) {
        ResponseEntity<?> entity = restTemplate.exchange(url,HttpMethod.DELETE,payload,c);
        return entity;
    }
}
