package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;
import technology.grameen.gphc.app.services.medicine.MedicineGroupService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/medicine-groups")
public class MedicineGroupController {

    private static final Integer SIZE = 20;
    @Autowired
    private MedicineGroupService medicineGroupService;

    @GetMapping
    public ResponseEntity<?> getAllPagesByName(@RequestParam Optional<String> name,
                                               @RequestParam Optional<Integer> page,
                                               @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(SIZE));
       return ResponseEntity.ok()
               .body(medicineGroupService.getMedicineGroupsByName(name.orElse(""),pageable));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllByName(@RequestParam Optional<String> name){
        return ResponseEntity.ok()
                .body(medicineGroupService.getMedicineGroupsByName(name.orElse("")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        return new ResponseEntity<>(
                medicineGroupService.getMedicineGroupsById(UUID.fromString(id)),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> addMedicineGroup(@RequestBody MedicineGroup medicineGroup)
                                                    throws CustomException {
        medicineGroupService.add(medicineGroup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
