package technology.grameen.gphc.app.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.profile.DoctorProfile;
import technology.grameen.gphc.app.healthapp.repositories.DoctorProfileRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorProfileServiceImpl implements DoctorProfileService{

    @Autowired
    private DoctorProfileRepository doctorProfileRepository;

    @Override
    @Transactional
    public DoctorProfile addDoctorProfile(DoctorProfile doctorProfile) {
        return doctorProfileRepository.save(doctorProfile);
    }

    @Override
    public Optional<?> getDetailByProfile(UUID id) {
        return doctorProfileRepository.findById(id);
    }
}
