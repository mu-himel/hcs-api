package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;
import technology.grameen.gphc.app.services.prescription.ChiefComplaintService;

@RestController
@RequestMapping("/api/v1/chief-complaints")
public class ChiefComplaintController {

    @Autowired
    private ChiefComplaintService chiefComplaintService;

    @PostMapping
    public ResponseEntity<?> addChiefComplaint(@RequestBody ChiefComplaint chiefComplaint) throws CustomException {
        chiefComplaintService.add(chiefComplaint);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(chiefComplaintService.getAll(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetail(@PathVariable("id") String id){
        return new ResponseEntity<>(chiefComplaintService.getDetail(id),
                HttpStatus.OK);
    }
}
