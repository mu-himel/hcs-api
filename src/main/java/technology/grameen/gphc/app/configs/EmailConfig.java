package technology.grameen.gphc.app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {



    @Bean
    public JavaMailSender getEmailSender(){
        JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
        emailSender.setHost("webmail.grameen.technology");
        emailSender.setPort(25);
        emailSender.setUsername("gcloud@grameen.technology");
        emailSender.setPassword("gcloud@grameen.technology");

        Properties properties = emailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",false);
        properties.put("mail.debug",true);
        return emailSender;
    }
}
