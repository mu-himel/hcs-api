package technology.grameen.gphc.app.services.network;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface NetworkService {

    public HttpStatus SUCCESS_WITH_NO_CONTENT = HttpStatus.NO_CONTENT;
    public HttpStatus OK = HttpStatus.OK;
    public HttpStatus CREATED = HttpStatus.CREATED;

    ResponseEntity<?> get(String url,  HttpEntity<?> payload, Class<?> C);
    ResponseEntity<?> post(String url, HttpEntity<?> payload, Class<?> C);
    ResponseEntity<?> put(String url, HttpEntity<?> payload, Class<?> C);
    ResponseEntity<?> delete(String url, HttpEntity<?> payload, Class<?> C);
}
