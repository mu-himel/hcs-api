package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.prescription.Advice;
import technology.grameen.gphc.app.services.prescription.AdviceService;

@RestController
@RequestMapping("/api/v1/advices")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @PostMapping
    public ResponseEntity<?> addAdvice(@RequestBody Advice advice){
        adviceService.add(advice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAdvices(){
        return new ResponseEntity<>(
                adviceService.getAll(),
                HttpStatus.OK
        );
    }
}
