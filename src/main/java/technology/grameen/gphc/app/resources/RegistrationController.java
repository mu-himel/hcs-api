package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.request.OtpSendRequest;
import technology.grameen.gphc.app.request.OtpValidate;
import technology.grameen.gphc.app.request.RegistrationRequest;
import technology.grameen.gphc.app.response.SimpleResponse;
import technology.grameen.gphc.app.services.profile.ProfileService;
import technology.grameen.gphc.app.services.security.OtpService;
import technology.grameen.gphc.app.services.security.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @Autowired
    private OtpService otpService;


    @PostMapping
    public ResponseEntity<?> userRegistration(@RequestBody RegistrationRequest registrationRequest) throws CustomException {
        profileService.register(registrationRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOTPRequest(@RequestBody OtpSendRequest otpRequest) throws CustomException {

        Optional<?> hasUserAccountByEmail = userService.findUserByEmail(otpRequest.getEmail());

        if(hasUserAccountByEmail.isPresent()){
            throw new CustomException("Sorry! Email address already Exist");
        }

        Optional<?> hasUserAccountByUsername = userService.findUserByUsername(otpRequest.getEmail());
        if(hasUserAccountByUsername.isPresent()){
            throw new CustomException("Sorry! Email already Exist");
        }

        Optional<?> hasEmail = profileService.getProfileByEmail(otpRequest.getEmail());
        if(hasEmail.isPresent()){
            throw new CustomException("Sorry! Email address already Exist");
        }

        String msg =  "Otp has been send to "+ otpRequest.getEmail();
        Boolean send = otpService.sendOtp(otpRequest);
        return new ResponseEntity<>(
                send? new SimpleResponse(HttpStatus.CREATED.value(),Optional.of(OtpService.DURATION),
                        msg) : new SimpleResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),Optional.of(false),
                        "Sorry! try again later"),
                send?  HttpStatus.CREATED : HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestBody OtpValidate otpValidate) throws CustomException {
        Boolean validOtp = otpService.validateOtp(otpValidate);
        return new ResponseEntity<>(
            validOtp? new SimpleResponse(HttpStatus.OK.value(), Optional.of(validOtp),"Otp is valid") :
                new SimpleResponse(HttpStatus.OK.value(), Optional.of(validOtp),"Sorry! Otp Expired, Resent"),
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
