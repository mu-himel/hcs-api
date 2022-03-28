package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;
import technology.grameen.gphc.app.services.medicine.MedicineService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medicines")
public class MedicineController {

    private static final Integer SIZE = 20;
    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public ResponseEntity<?> getAllPagesByName(@RequestParam Optional<String> name,
                                               @RequestParam Optional<Integer> page,
                                               @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(SIZE));
        return ResponseEntity.ok()
                .body(medicineService.getMedicineByName(name.orElse(""),pageable));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListByName(@RequestParam("name") Optional<String> name){
        return ResponseEntity.ok().body(medicineService.getMedicineListByName(name.orElse("")));
    }


    @PostMapping
    public ResponseEntity<?> addMedicine(@RequestBody Medicine medicine) throws CustomException {
        medicineService.addMedicine(medicine);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
