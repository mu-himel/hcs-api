package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.configuration.TriageConfiguration;
import technology.grameen.gphc.app.services.config.TriageConfigService;

import javax.print.attribute.IntegerSyntax;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/configs/triage")
public class TriageConfigController {

    private static final Integer DEFAULT_PAGE_SIZE = 10;

    @Autowired
    private TriageConfigService triageConfigService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Optional<Integer> page,
                                    @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(DEFAULT_PAGE_SIZE));

        return new ResponseEntity<>(
              triageConfigService.getAll(pageable),
              HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addConfig(@RequestBody TriageConfiguration triageConfiguration){
        return new ResponseEntity<>(
                triageConfigService.addConfig(triageConfiguration),
                HttpStatus.CREATED
        );
    }
}
