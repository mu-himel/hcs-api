package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;
import technology.grameen.gphc.app.services.prescription.ChiefComplaintService;

@RestController
@RequestMapping("/api/v1/chief-complaints")
public class ChiefComplaintController {

    @Autowired
    private ChiefComplaintService chiefComplaintService;

    @PostMapping
    public ResponseEntity<?> addChiefComplaint(@RequestBody ChiefComplaint chiefComplaint){
        chiefComplaintService.add(chiefComplaint);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
