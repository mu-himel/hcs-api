package technology.grameen.gphc.app.services.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;
import technology.grameen.gphc.app.healthapp.repositories.PatientSubscriptionRepository;

import java.util.Optional;

@Service
public class PatientSubscriptionServiceImpl implements PatientSubscriptionService{

    @Autowired
    private PatientSubscriptionRepository patientSubscriptionRepository;

    @Override
    @Transactional
    public PatientSubscription subscribePackage(PatientSubscription patientSubscription) {
        return patientSubscriptionRepository.save(patientSubscription);
    }

    @Override
    public Optional<?> getPatientSubscriptionByProfile(Profile profile) {
        return patientSubscriptionRepository.findSubscriptionByProfile(profile);
    }
}
