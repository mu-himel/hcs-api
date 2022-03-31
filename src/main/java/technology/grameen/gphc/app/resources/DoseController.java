package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.prescription.Dose;
import technology.grameen.gphc.app.services.prescription.DoseService;

@RestController
@RequestMapping("/api/v1/doses")
public class DoseController {

    @Autowired
    private DoseService doseService;

    @PostMapping
    public ResponseEntity<?> addDose(@RequestBody Dose dose){
        doseService.addDose(dose);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getDoses(){
        return new ResponseEntity<>(
                doseService.getDoses(),
                HttpStatus.OK
        );
    }
}
