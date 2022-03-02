package technology.grameen.gphc.app.services.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    SimpleMailMessage simpleMailMessage;

    @Override
    public void send() {
        mailSender.send(simpleMailMessage);
    }

    @Override
    public void setSubject(String subject) {
        simpleMailMessage.setSubject(subject);
    }

    @Override
    public void setTo(String to) {
        simpleMailMessage.setTo(to);
    }

    @Override
    public void setFrom(String from) {
        simpleMailMessage.setFrom(from);
    }

    @Override
    public void setMessage(String message) {
        simpleMailMessage.setText(message);
    }


}
