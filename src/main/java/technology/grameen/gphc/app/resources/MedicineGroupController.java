package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;
import technology.grameen.gphc.app.services.medicine.MedicineGroupService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medicine-group")
public class MedicineGroupController {

    @Autowired
    private MedicineGroupService medicineGroupService;

    @GetMapping
    public ResponseEntity<?> getAllByName(@RequestParam Optional<String> name){
       return ResponseEntity.ok()
               .body(medicineGroupService.getMedicineGroupsByName(name.orElse("")));
    }

    @PostMapping
    public ResponseEntity<?> addMedicineGroup(@RequestBody MedicineGroup medicineGroup)
                                                    throws CustomException {
        medicineGroupService.add(medicineGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
