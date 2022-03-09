package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.profile.ResearcherProfile;
import technology.grameen.gphc.app.services.profile.ProfileService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profiles/researcher")
public class ResearcherProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<?> addResearcherProfile(ResearcherProfile researcherProfile){
        profileService.getResearcherProfileService().addResearcherProfile(researcherProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorProfileByProfileId(@PathVariable("id") String id){
        return new ResponseEntity<>(
            profileService.getResearcherProfileService().getDetailByProfieId(UUID.fromString(id)),
            HttpStatus.OK
        );
    }
}
