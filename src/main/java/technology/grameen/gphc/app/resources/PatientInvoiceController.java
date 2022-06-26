package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.services.invoice.PatientInvoiceService;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/invoice")
public class PatientInvoiceController {

    private static final Integer PAGE_SIZE = 20;
    @Autowired
    PatientInvoiceService patientInvoiceService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PatientInvoice patientInvoice){
        patientInvoiceService.saveInvoice(patientInvoice);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Optional<Integer> page,
                                    @RequestParam Optional<Integer> size){

        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(PAGE_SIZE));
        return new ResponseEntity<>(
                patientInvoiceService.getAll(pageable),
                HttpStatus.OK
        );
    }

    @GetMapping("/by-patient/{pid}")
    public ResponseEntity<?> getAllByPatient(@PathVariable("pid") UUID patientId, @RequestParam Optional<Integer> page,
                                             @RequestParam Optional<Integer> size){

        Profile patient = new Profile();
        patient.setId(patientId);
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(PAGE_SIZE));
        return new ResponseEntity<>(
                patientInvoiceService.getAll(patient,pageable),
                HttpStatus.OK
        );
    }

}
