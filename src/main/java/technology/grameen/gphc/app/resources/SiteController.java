package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.request.SiteServiceRequest;
import technology.grameen.gphc.app.request.SiteUserRequest;
import technology.grameen.gphc.app.services.site.SiteService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sites")
public class SiteController {

    private static final Integer PAGE_SIZE = 10;
    @Autowired
    private SiteService siteService;

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam Optional<Integer> page,
                                    @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0),size.orElse(PAGE_SIZE));

        return new ResponseEntity<>(
                siteService.getAll(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("/list")
    public ResponseEntity<?> getSiteList(){
        return new ResponseEntity<>(
          siteService.getAll(),
          HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSite(@PathVariable String id){
        return new ResponseEntity<>(
                siteService.getSiteById(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSite(@RequestBody Site site) throws CustomException {
        siteService.addSite(site);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/users")
    public ResponseEntity<?> assignSiteUser(@RequestBody SiteUserRequest siteUserRequest) throws CustomException {
        siteService.assignUser(siteUserRequest.getSiteUsers());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users/{siteId}")
    public ResponseEntity<?> getSiteUsers(@PathVariable("siteId") String siteId){
        return new ResponseEntity<>(
                siteService.getSiteUser().getUsers(UUID.fromString(siteId)),
                HttpStatus.OK
        );
    }

    @PostMapping("/services")
    public ResponseEntity<?> addHealthService(@RequestBody SiteServiceRequest siteServiceRequest)
            throws CustomException {
        siteService.getSiteHealthService().add(siteServiceRequest.getSiteServices());
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @GetMapping("/services/{siteId}")
    public ResponseEntity<?> getSiteServices(@PathVariable("siteId") String siteId)
            throws CustomException {

        if(siteId == null || siteId.isEmpty()){
            throw new CustomException("Site ID Required");
        }

        Site site = new Site();
        site.setId(UUID.fromString(siteId));

        return new ResponseEntity<>(
                siteService.getSiteHealthService().getHealthServices(site),
                HttpStatus.OK
        );
    }
}
