package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.Site;
import technology.grameen.gphc.app.services.site.SiteService;

import java.util.Optional;

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
}
