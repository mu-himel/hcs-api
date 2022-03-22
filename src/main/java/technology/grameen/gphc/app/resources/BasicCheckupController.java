package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.healthapp.entity.checkup.BasicCheckup;
import technology.grameen.gphc.app.request.BasicCheckupRequest;
import technology.grameen.gphc.app.services.checkup.CheckupService;
import technology.grameen.gphc.app.services.ehr.CompositionService;

@RestController
@RequestMapping("/api/v1/checkup")
public class BasicCheckupController {

    @Autowired
    private CheckupService checkupService;

    @Autowired
    private CompositionService compositionService;

    @PostMapping
    public ResponseEntity<?> addCheckup(@RequestBody BasicCheckupRequest basicCheckupReq){
        BasicCheckup basicCheckup = checkupService.add(basicCheckupReq.getBasicCheckup());
        compositionService.addEhr(basicCheckupReq.getEhr());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
