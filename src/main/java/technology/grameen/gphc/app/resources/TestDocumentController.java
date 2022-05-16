package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.profile.TestDocument;
import technology.grameen.gphc.app.services.profile.TestDocumentService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/test-docs")
public class TestDocumentController {

    private static final Integer PAGE_LIMIT = 20;

    @Autowired
    private TestDocumentService testDocumentService;

    @PostMapping("/add")
    public ResponseEntity<?> addTestDocument(@RequestBody TestDocument testDocument){
        testDocumentService.addTestDocument(testDocument);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam Optional<Integer> page,
                                    @RequestParam Optional<Integer> size){
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(PAGE_LIMIT));

        return new ResponseEntity<>(
                testDocumentService.getAll(pageable),
                HttpStatus.OK
        );
    }
}
