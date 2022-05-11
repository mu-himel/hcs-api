package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.component.UrlBuilder;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.profile.ProfileUser;
import technology.grameen.gphc.app.request.UserProfileRequest;
import technology.grameen.gphc.app.services.network.NetworkService;
import technology.grameen.gphc.app.services.profile.ProfileService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private static final Integer PAGE_SIZE = 10;
    @Autowired
    private ProfileService profileService;




    @GetMapping("")
    public ResponseEntity<?> all( @RequestParam Optional<Integer> page,
                                  @RequestParam Optional<Integer> size,
                                  @RequestParam Optional<String> firstName,
                                  @RequestParam Optional<String> lastName,
                                  @RequestParam Optional<String> email,
                                  @RequestParam Optional<String> contactNumber,
                                  @RequestParam Optional<String> siteId,
                                  @RequestParam Optional<String> roleId){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));
        Page<?> pages = profileService.getAll(pageable,firstName,lastName,email,
                contactNumber,siteId,roleId);
        return new ResponseEntity<>(
                pages,
                HttpStatus.OK
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfile(@PathVariable("id") String id){
        Optional<?> profileUserOp = profileService.getProfileById(UUID.fromString(id));


        return new ResponseEntity<>(
                profileUserOp,
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

    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addUserProfile(@PathVariable("id") String id, @RequestBody UserProfileRequest usr){
        Profile profile = profileService.addProfile(usr.getProfile());
        profileService.addProfileUser(usr.getUser(),profile,new ProfileUser());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProfile(@RequestBody Profile profile) throws CustomException {
        return new ResponseEntity<>(
                profileService.register(profile),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable("id") String id, @RequestBody Profile profile)
                                                throws CustomException {
        profileService.updateProfile(id,profile);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/user/{id}/role")
    public ResponseEntity<?> updateProfileRole(@PathVariable("id") String id, @RequestBody Map<String,String> role){
        profileService.updateRoleOnProfile(id,role.get("id"));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
