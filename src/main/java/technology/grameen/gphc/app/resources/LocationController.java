package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.services.CityService;
import technology.grameen.gphc.app.services.CountryService;
import technology.grameen.gphc.app.services.location.StateService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CityService cityService;

    @GetMapping("/countries")
    public ResponseEntity<?> getCountryList(@RequestParam Optional<String> name){
        return new ResponseEntity<>(
             countryService.getCountries(name.orElse("")),
             HttpStatus.OK
        );
    }

    @GetMapping("/states")
    public ResponseEntity<?> getStateList(@RequestParam Optional<String> name){
        return new ResponseEntity<>(
            stateService.getStates(name.orElse("")),
            HttpStatus.OK
        );
    }

    @GetMapping("/cities")
    public ResponseEntity<?> getCityList(@RequestParam Optional<String> name){
        return new ResponseEntity<>(
            cityService.getCities(name.orElse("")),
            HttpStatus.OK
        );
    }


}
