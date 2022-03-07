package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;
import technology.grameen.gphc.app.services.healthservice.ServiceCategoryService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/service-categories")
public class ServiceCategoryController {

    private static final Integer PAGE_SIZE = 10;
    @Autowired
    private ServiceCategoryService serviceCategoryService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(
          serviceCategoryService.getCategories()
        ,HttpStatus.OK);
    }

    @RequestMapping(value = "")
    public ResponseEntity<?> list(
            @RequestParam Optional<String> name,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<String> sortBy,
            @RequestParam Optional<Boolean> sortDesc){
        String _sortBy = sortBy.orElse(null);

        Sort sort = null;
        if(!_sortBy.isEmpty()) {
            sort =   (sortDesc.orElse(false)) ? Sort.by(_sortBy).descending()
                    : Sort.by(_sortBy).ascending();
        }
        Pageable pageable = (sort!=null)? PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE),sort)
                : PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(
                serviceCategoryService.getCategories(name.orElse(""),pageable), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addCategory(@RequestBody ServiceCategory req) throws CustomException {
        ServiceCategory serviceCategory = serviceCategoryService.addCategory(req);
        return new ResponseEntity<>(serviceCategory, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> geteCategoryById(@PathVariable("id") String id){
        Optional <?> serviceCategory = serviceCategoryService.findById(UUID.fromString(id));
        return new ResponseEntity<>(serviceCategory, HttpStatus.OK);
    }

    @GetMapping("/by-code/{code}")
    public ResponseEntity<?> getServiceCategoryByAlias(@PathVariable("code") String code){
        return new ResponseEntity<>(
                serviceCategoryService.findByCode(code)
        , HttpStatus.OK);
    }
}
