package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.profile.MedicalHistory;
import technology.grameen.gphc.app.services.profile.MedicalHistoryService;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/medical-histories")
public class MedicalHistoryController {

    private static final Integer PAGE_LIMIT = 20;
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @PostMapping("/add")
    public ResponseEntity<?> addMedicalHistory(@RequestBody MedicalHistory medicalHistory){
        medicalHistoryService.addMedicalHistory(medicalHistory);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @PutMapping("/:id")
    public ResponseEntity<?> updateMedicalHistory(@RequestBody MedicalHistory medicalHistory,
                                                  @PathVariable("id") String id){
        medicalHistoryService.updateMedicalHistory(id,medicalHistory);
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }


    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam Optional<Integer> page,
                                    @RequestParam Optional<Integer> size
                                    ){
        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(PAGE_LIMIT));

        return new ResponseEntity<>(
                medicalHistoryService.getAll(pageable),
                HttpStatus.OK
        );
    }
}
