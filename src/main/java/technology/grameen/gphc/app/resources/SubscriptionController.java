package technology.grameen.gphc.app.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.healthapp.entity.site.SitePackage;
import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

    @PostMapping("/org")
    public ResponseEntity<?> subscribeOrganization(@RequestBody SitePackage sitePackage){
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @PostMapping("/individual")
    public ResponseEntity<?> subscribeIndividual(@RequestBody PatientSubscription patientSubscription){
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

}
