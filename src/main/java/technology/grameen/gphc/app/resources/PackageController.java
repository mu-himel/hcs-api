package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;
import technology.grameen.gphc.app.services.subscription.PackageService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packages")
public class PackageController {

    private static final Integer PAGE_LIMIT = 20;

    @Autowired
    private PackageService packageService;

    @PostMapping("/add")
    public ResponseEntity<?> addPackage(@RequestBody SubscriptionPackage subscriptionPackage){
        packageService.addPackage(subscriptionPackage);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePackage(@PathVariable("id") String id,
                                           @RequestBody SubscriptionPackage subscriptionPackage){

        packageService.updatePackage(id, subscriptionPackage);
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPackageById(@PathVariable("id") String id){
        return new ResponseEntity<>(
                packageService.getPackageById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam("name") Optional<String> name){

        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(PAGE_LIMIT));
        return new ResponseEntity<>(
                packageService.getAll(name.orElse(""), pageable),
                HttpStatus.OK
        );
    }

}
