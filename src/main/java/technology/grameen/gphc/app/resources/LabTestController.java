package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;
import technology.grameen.gphc.app.healthapp.repositories.ServiceCategoryRepository;
import technology.grameen.gphc.app.services.healthservice.HealthService;
import technology.grameen.gphc.app.services.healthservice.ServiceCategoryService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lab-tests")
public class LabTestController {

    @Autowired
    private ServiceCategoryService serviceCategoryService;

    @Autowired
    private HealthService healthService;

    @GetMapping
    public ResponseEntity<?> getLabTests(@RequestParam String code){
        Optional<ServiceCategoryRepository.IServiceCategory> sc = serviceCategoryService.findByCode(code);
        if(sc.isPresent()){
            ServiceCategory serviceCategory = new ServiceCategory();
            serviceCategory.setId(sc.get().getId());
            return new ResponseEntity<>(
                    healthService.findByServiceCategory(serviceCategory),
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
