package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.prescription.Disease;
import technology.grameen.gphc.app.services.prescription.DiseaseService;

@RestController
@RequestMapping("/api/v1/diseases")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @PostMapping
    public ResponseEntity<?> addDisease(@RequestBody Disease disease){
        diseaseService.add(disease);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(diseaseService.getAll(),HttpStatus.OK);
    }
}
