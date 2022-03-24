package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
