package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.Hospital;
import technology.grameen.gphc.app.services.prescription.HospitalService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private static final Integer SIZE = 20;
    @Autowired
    private HospitalService hospitalService;


    @PostMapping
    public ResponseEntity<?> addHospital(@RequestBody @Valid Hospital hospital) throws CustomException {
        hospitalService.addHospital(hospital);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getHospiatal(@RequestParam Optional<Integer> page,
                                          @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(SIZE));

        return new ResponseEntity<>(
                hospitalService.getHospitals(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("/list")
    public ResponseEntity<?> getHospitals(String name){
        return new ResponseEntity<>(
                hospitalService.getHospitals(name),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHospital(@PathVariable("id") String id){
        return new ResponseEntity<>(
                hospitalService.getHospitalById(id),
                HttpStatus.OK
        );
    }
}
