package technology.grameen.gphc.app.services.notify;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService extends NotificationProvider {

    void setSubject(String subject);
    void setFrom(String from);
    void setMessage(String message);
    void setTo(String to);
}
