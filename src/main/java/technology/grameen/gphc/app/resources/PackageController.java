package technology.grameen.gphc.app.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packages")
public class PackageController {

    @PostMapping("/add")
    public ResponseEntity<?> addPackage(@RequestBody SubscriptionPackage subscriptionPackage){
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePackage(@PathVariable("id") String id,
                                           @RequestBody SubscriptionPackage subscriptionPackage){
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPackageById(@PathVariable("id") String id){
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Optional<Integer> page,
                                    @RequestParam Optional<Integer> size){
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

}
