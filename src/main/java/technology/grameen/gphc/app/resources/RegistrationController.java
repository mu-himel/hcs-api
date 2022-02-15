package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.services.profile.ProfileService;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<?> userRegistration(@RequestBody Profile profile){
        profileService.register(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable String id, @RequestBody Profile profile){
        profileService.updateProfile(id,profile);
        return new ResponseEntity<>(
            HttpStatus.NO_CONTENT
        );
    }
}
