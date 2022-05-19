package technology.grameen.gphc.app.services.subscription;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;
import technology.grameen.gphc.app.healthapp.repositories.PatientSubscriptionRepository;

@Service
public class PatientSubscriptionServiceImpl implements PatientSubscriptionService{

    private PatientSubscriptionRepository patientSubscriptionRepository;

    @Override
    @Transactional
    public PatientSubscription subscribePackage(PatientSubscription patientSubscription) {
        return patientSubscriptionRepository.save(patientSubscription);
    }
}
