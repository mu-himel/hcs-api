package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.services.profile.ProfileService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(
          profileService.getProfileUsers(),
          HttpStatus.OK
        );
    }
}
