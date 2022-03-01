package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.services.profile.ProfileService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private static final Integer PAGE_SIZE = 10;
    @Autowired
    private ProfileService profileService;


    @GetMapping("")
    public ResponseEntity<?> all(@RequestParam Optional<Integer> page,
                                 @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(
                profileService.getAll(pageable),
                HttpStatus.OK
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfile(@PathVariable("id") String id){
        return new ResponseEntity<>(
          profileService.getProfileById(UUID.fromString(id)),
          HttpStatus.OK
        );
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable("id") String id){
        return new ResponseEntity<>(
                profileService.getProfileByUserId(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProfile(@RequestBody Profile profile) throws CustomException {
        return new ResponseEntity<>(
                profileService.register(profile),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id") String id, @RequestBody Profile profile){
        profileService.updateProfile(id,profile);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
