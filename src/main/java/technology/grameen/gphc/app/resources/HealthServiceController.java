package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.service.Service;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;
import technology.grameen.gphc.app.healthapp.repositories.HealthServiceRepository;
import technology.grameen.gphc.app.services.healthservice.HealthService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/services")
public class HealthServiceController {

    private final Integer PAGE_SIZE = 10;

    @Autowired
    private HealthService healthService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(
                healthService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "")
    public ResponseEntity<?> list(
            @RequestParam Optional<String> serviceName,
            @RequestParam Optional<String> serviceCode,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<String> sortBy,
            @RequestParam Optional<Boolean> sortDesc){

        String _sortBy = sortBy.orElse(null);
//        _sortBy = (_sortBy.contains("active")) ? "isActive":_sortBy;
        //_sortBy = (_sortBy.contains("labTestGroup")) ? "labTestGroup":_sortBy;

        Sort sort = null;
        if(_sortBy!= null && !_sortBy.isEmpty()) {
            sort =   (sortDesc.orElse(false)) ? Sort.by(_sortBy).descending()
                    : Sort.by(_sortBy).ascending();
        }
        Pageable pageable = (sort!=null)? PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE),sort)
                : PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(
                healthService.getAll(serviceName.orElse(""),serviceCode.orElse(""),pageable),
                HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addService(@RequestBody Service req) throws CustomException {

        Service service = healthService.addService(req);
        return new ResponseEntity<>(service, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update")
    public ResponseEntity<Service> updateService(@RequestBody Service req) throws CustomException {

        Service service = healthService.addService(req);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable("id") String id){
        Optional<?> service = healthService.findServiceById(UUID.fromString(id));
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping(value = "/by-category/{id}")
    public ResponseEntity<?> findServiceByServiceCategory(@PathVariable("id") String categoryId){
        return new ResponseEntity<>(
                healthService.findByServiceCategory(new ServiceCategory(UUID.fromString(categoryId)))
        , HttpStatus.OK);
    }
}
