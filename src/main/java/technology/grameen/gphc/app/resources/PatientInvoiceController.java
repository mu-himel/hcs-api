package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import technology.grameen.gphc.app.healthapp.entity.invoice.PatientInvoice;
import technology.grameen.gphc.app.services.invoice.PatientInvoiceService;

@RestController
@RequestMapping("/api/v1/invoice")
public class PatientInvoiceController {

    @Autowired
    PatientInvoiceService patientInvoiceService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PatientInvoice patientInvoice){
        patientInvoiceService.saveInvoice(patientInvoice);
        return new ResponseEntity<>(
                HttpStatus.CREATED
        );
    }

}
