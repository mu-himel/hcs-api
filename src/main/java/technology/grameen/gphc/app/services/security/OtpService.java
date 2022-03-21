package technology.grameen.gphc.app.services.security;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.request.OtpSendRequest;
import technology.grameen.gphc.app.request.OtpValidate;

public interface OtpService {

    final static Long DURATION = 60L;

    Boolean sendOtp(OtpSendRequest otpSendRequest) throws CustomException;

    Boolean validateOtp(OtpValidate otpValidate) throws CustomException;

    String generateOtpToken(int len);
}
