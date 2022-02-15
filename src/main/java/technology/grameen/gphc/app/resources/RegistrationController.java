package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.services.profile.ProfileService;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<?> userRegistration(@RequestBody Profile profile){
        return new ResponseEntity<>(
                profileService.register(profile),
                HttpStatus.CREATED
        );
    }
}
