package technology.grameen.gphc.app.services.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService, EmailService{

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void notifyUser() {

    }

    @Override
    public void sendEmail() {
        String message = "Hello Bhai email gese?";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("gcloud@grameen.technology");
        simpleMailMessage.setTo("islam.shaiful7@gmail.com");
        simpleMailMessage.setSubject("Test");
        simpleMailMessage.setText(message);
        mailSender.send(simpleMailMessage);
    }
}
