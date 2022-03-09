package technology.grameen.gphc.app.services.profile;

import technology.grameen.gphc.app.healthapp.entity.profile.DoctorProfile;

import java.util.Optional;
import java.util.UUID;

public interface DoctorProfileService {

    DoctorProfile addDoctorProfile(DoctorProfile doctorProfile);

    Optional<?> getDetailByProfile(UUID id);
}
