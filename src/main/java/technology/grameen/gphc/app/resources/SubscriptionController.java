package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.healthapp.entity.site.SitePackage;
import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;
import technology.grameen.gphc.app.services.subscription.PatientSubscriptionService;
import technology.grameen.gphc.app.services.subscription.SitePackageSubscriptionService;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

    @Autowired
    private SitePackageSubscriptionService siteSubscriptionService;

    @Autowired
    private PatientSubscriptionService patientSubscriptionService;

    @PostMapping("/org")
    public ResponseEntity<?> subscribeOrganization(@RequestBody SitePackage sitePackage){
        return new ResponseEntity<>(
                siteSubscriptionService.subscribePackage(sitePackage),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/individual")
    public ResponseEntity<?> subscribeIndividual(@RequestBody PatientSubscription patientSubscription){
        return new ResponseEntity<>(
                patientSubscriptionService.subscribePackage(patientSubscription),
                HttpStatus.CREATED
        );
    }

}
