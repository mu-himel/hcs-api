package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gphc.app.request.fhir.NameInfo;
import technology.grameen.gphc.app.request.fhir.Patient;
import technology.grameen.gphc.app.services.notify.EmailService;
import technology.grameen.gphc.app.services.notify.NotificationService;
import technology.grameen.gphc.app.services.register.FhirRegisterService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/send")
public class NotifyController {

    @Autowired
    EmailService emailService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    private FhirRegisterService registerService;

    @GetMapping("/email")
    public ResponseEntity<?> sendEmail(){

        String message = "Hello Bhai email gese?";
        emailService.setSubject("OTP Send from GPHC registration");
        emailService.setFrom("gcloud@grameen.technology");
        emailService.setTo("mu.himel@gmail.com");
        emailService.setMessage(message);
        notificationService.setNotificationProvider(emailService);
        notificationService.notifyUser();
        return new ResponseEntity<>(
                message,
                HttpStatus.OK
        );
    }

    @GetMapping("/patient-id")
    public ResponseEntity<?> getPatientId(){

        Patient p = new Patient();
        List<NameInfo> nameInfoList=new ArrayList<>();
        nameInfoList.add(new NameInfo("Mehearaz","Himel"));
        p.setName(nameInfoList);
      return new ResponseEntity<>(
              registerService.registerPatient(p),
              HttpStatus.OK);
    }
}
