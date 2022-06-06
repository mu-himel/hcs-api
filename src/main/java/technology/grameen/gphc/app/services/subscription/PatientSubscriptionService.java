package technology.grameen.gphc.app.services.subscription;

import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.subscription.PatientSubscription;

import java.util.Optional;

public interface PatientSubscriptionService {

    PatientSubscription subscribePackage(PatientSubscription patientSubscription);

    Optional<?> getPatientSubscriptionByProfile(Profile profile);
}
