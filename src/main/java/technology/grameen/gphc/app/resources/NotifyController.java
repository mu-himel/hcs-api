package technology.grameen.gphc.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.SendFailedException;

@RestController
@RequestMapping("/api/v1/send")
public class NotifyController {

    @Autowired
    JavaMailSender mailSender;

    @GetMapping("/email")
    public ResponseEntity<?> sendEmail(){

        String message = "Hello Bhai email gese?";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("gcloud@grameen.technology");
        simpleMailMessage.setTo("islam.shaiful7@gmail.com");
        simpleMailMessage.setSubject("Test");
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
        return new ResponseEntity<>(
                message,
                HttpStatus.OK
        );
    }
}
