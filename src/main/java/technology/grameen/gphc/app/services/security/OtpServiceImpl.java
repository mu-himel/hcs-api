package technology.grameen.gphc.app.services.security;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.security.OtpRequest;
import technology.grameen.gphc.app.healthapp.repositories.OtpRequestRepository;
import technology.grameen.gphc.app.request.OtpSendRequest;
import technology.grameen.gphc.app.request.OtpValidate;
import technology.grameen.gphc.app.services.notify.EmailService;
import technology.grameen.gphc.app.services.notify.NotificationService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpServiceImpl implements OtpService{

    @Autowired
    private OtpRequestRepository otpRequestRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    NotificationService notificationService;

    @Override
    public Boolean sendOtp(OtpSendRequest otpSendRequest) throws CustomException {
        OtpRequest otpRequest = new OtpRequest();
        otpRequest.setExpiredAt(LocalDateTime.now(),OtpService.DURATION);
        otpRequest.setEmail(otpSendRequest.getEmail());
        otpRequest.setOtp(generateOtpToken(6));
        try{
            OtpRequest otp = otpRequestRepository.save(otpRequest);
            sendOtpNotification(otpRequest);
        }catch (Exception ex){
            throw new CustomException("Sorry! "+ ex.getMessage());
        }

        return true;
    }

    private void sendOtpNotification(OtpRequest otpRequest){
        String message = "One Time Password : "+otpRequest.getOtp()+"\r\nThis OTP is valid for 60 seconds";
        emailService.setSubject("OTP Send from GPHC registration");
        emailService.setFrom("gcloud@grameen.technology");
        emailService.setTo(otpRequest.getEmail());
        emailService.setMessage(message);
        notificationService.setNotificationProvider(emailService);
        notificationService.notifyUser();
    }

    @Override
    @Transactional
    public Boolean validateOtp(OtpValidate otpValidate) throws CustomException {

        Optional<OtpRequest> hasOtpRequest = otpRequestRepository.findByOtp(otpValidate.getOtp());
        if(!hasOtpRequest.isPresent()){
            throw new CustomException("Sorry! Otp Invalid");
        }

        OtpRequest otpRequest = hasOtpRequest.get();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiredAt = otpRequest.getExpiredAt();

        if(otpRequest.getVerified()){
            throw new CustomException("Sorry! Otp already verified");
        }

        if(!expiredAt.isAfter(now)){
            throw new CustomException("Sorry! Otp has been expired");
        }

        // update otp to verified
        otpRequest.setVerified(true);

        return true;
    }

    private String generateOtpToken(int len){
        String otpToken = "";
        for(int i=1; i<=len; i++){
            Double randomDigit = Math.random()*10;
            Integer digit = randomDigit.intValue();
            otpToken += String.valueOf(digit);
        }
        return otpToken;
    }
}
