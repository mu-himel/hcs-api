package technology.grameen.gphc.app.services.notify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    private NotificationProvider notificationProvider;

    @Override
    public void notifyUser() {
        notificationProvider.send();
    }

    public void setNotificationProvider(NotificationProvider notificationProvider){
        this.notificationProvider = notificationProvider;
    }
}
