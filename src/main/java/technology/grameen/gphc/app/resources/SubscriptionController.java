package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SitePackage;
import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;
import technology.grameen.gphc.app.services.security.OtpService;
import technology.grameen.gphc.app.services.subscription.PatientSubscriptionService;
import technology.grameen.gphc.app.services.subscription.SitePackageSubscriptionService;

import javax.xml.ws.Response;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

    private static final Integer PAGE_SIZE = 20;
    @Autowired
    private SitePackageSubscriptionService siteSubscriptionService;

    @Autowired
    private PatientSubscriptionService patientSubscriptionService;

    @Autowired
    private OtpService otpService;

    @PostMapping("/org")
    public ResponseEntity<?> subscribeOrganization(@RequestBody SitePackage sitePackage){
        String code = sitePackage.getSubscriptionPackage().getPackageCode()+"-"+otpService.generateOtpToken(6);
        sitePackage.setCode(code);
        siteSubscriptionService.subscribePackage(sitePackage);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @GetMapping("/site")
    public ResponseEntity<?> getOrganizationSubscription(@RequestParam Optional<Integer> page,
                                                         @RequestParam Optional<Integer> size) {

        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(
                siteSubscriptionService.getSiteSubscriptions(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("/site/list/{id}")
    public ResponseEntity<?> getOrganizationSubscription(@PathVariable("id") String siteId,
                                                         @RequestParam Optional<Integer> page,
                                                         @RequestParam Optional<Integer> size) {
        Site site = new Site();
        site.setId(UUID.fromString(siteId));

        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(PAGE_SIZE));
        return new ResponseEntity<>(
                siteSubscriptionService.getSiteSubscriptionsBySite(site, pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("/site/{id}")
    public ResponseEntity<?> getOrganizationSubscription(@PathVariable("id") String id) {

        return new ResponseEntity<>(
                siteSubscriptionService.getSiteSubscriptionsById(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/individual")
    public ResponseEntity<?> subscribeIndividual(@RequestBody PatientSubscription patientSubscription){
        String code = patientSubscription.getSubscriptionPackage().getPackageCode()+"-"+otpService.generateOtpToken(6);
        patientSubscription.setCode(code);
        patientSubscriptionService.subscribePackage(patientSubscription);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @GetMapping("/individual")
    public ResponseEntity<?> getIndividualSubscriptionByProfile(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size
            ) {

        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(PAGE_SIZE));
        
        return new ResponseEntity<>(
                patientSubscriptionService.getPatientSubscriptions(pageable),
                HttpStatus.OK
        );

    }

    @GetMapping("/individual/profile/{id}")
    public ResponseEntity<?> getIndividualSubscriptionByProfile(@PathVariable("id") String id) {
        Profile profile = new Profile();
        profile.setId(UUID.fromString(id));
        return new ResponseEntity<>(
                patientSubscriptionService.getPatientSubscriptionByProfile(profile),
                HttpStatus.OK
        );

    }

    @GetMapping("/individual/{id}")
    public ResponseEntity<?> getIndividualSubscriptionByID(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                patientSubscriptionService.getPatientSubscriptionById(id),
                HttpStatus.OK
        );

    }

}
