package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.request.OtpRequest;
import technology.grameen.gphc.app.request.OtpValidate;
import technology.grameen.gphc.app.services.profile.ProfileService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<?> userRegistration(@RequestBody Profile profile) throws CustomException {
        profileService.register(profile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOTPRequest(@RequestBody OtpRequest otpRequest){
        return new ResponseEntity<>(
                UUID.randomUUID(),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestBody OtpValidate otpValidate){
        return new ResponseEntity<>(
                null,
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable String id, @RequestBody Profile profile){
        profileService.updateProfile(id,profile);
        return new ResponseEntity<>(
            HttpStatus.NO_CONTENT
        );
    }
}
