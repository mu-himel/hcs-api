package technology.grameen.gphc.app.services.subscription;

import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;

public interface PatientSubscriptionService {
    PatientSubscription subscribePackage(PatientSubscription patientSubscription);
}
