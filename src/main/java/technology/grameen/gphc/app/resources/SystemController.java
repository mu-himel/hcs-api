package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.configuration.SystemConfiguration;
import technology.grameen.gphc.app.services.config.SystemConfigService;

@RestController
@RequestMapping("/api/v1/system")
public class SystemController {

    @Autowired
    private SystemConfigService systemConfigService;

    @PostMapping
    public ResponseEntity<?> addSystemConfig(@RequestBody SystemConfiguration systemConfiguration){
        systemConfigService.addConfig(systemConfiguration);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );

    }

    @GetMapping
    public ResponseEntity<?> getSystemConfig(){
        return new ResponseEntity<>(
                systemConfigService.getSystemConfig(),
                HttpStatus.OK
        );
    }
}
