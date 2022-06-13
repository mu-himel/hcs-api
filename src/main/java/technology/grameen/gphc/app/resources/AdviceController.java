package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.Advice;
import technology.grameen.gphc.app.services.prescription.AdviceService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/advices")
public class AdviceController {

    private static final Integer SIZE = 20;
    @Autowired
    private AdviceService adviceService;

    @PostMapping
    public ResponseEntity<?> addAdvice(@RequestBody Advice advice) throws CustomException {
        adviceService.add(advice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAdvices(@RequestParam Optional<Integer> page,
                                        @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(SIZE));
        return new ResponseEntity<>(
            adviceService.getAll(pageable),
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdviceById(@PathVariable("id") String id){
        return new ResponseEntity<>(
          adviceService.getById(id),
          HttpStatus.OK
        );
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAdvices(){
        return new ResponseEntity<>(
            adviceService.getAll(),
            HttpStatus.OK
        );
    }
}
