package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.configuration.EmailConfiguration;
import technology.grameen.gphc.app.services.config.EmailConfigService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/configs/email")
public class EmailConfigController {

    private static final Integer DEFAULT_PAGE_SIZE = 10;

    @Autowired
    private EmailConfigService emailConfigService;

    @GetMapping("")
    public ResponseEntity<?> getConfigs(@RequestParam Optional<Integer> page,
                                        @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(DEFAULT_PAGE_SIZE));

        return new ResponseEntity<>(
                emailConfigService.getAll(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("/default")
    public ResponseEntity<?> getDefaultConfig(){
        return new ResponseEntity<>(
                emailConfigService.getDefaultConfig(),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addConfig(@RequestBody EmailConfiguration config){
        return new ResponseEntity<>(
            emailConfigService.add(config),
            HttpStatus.CREATED
        );
    }

}
