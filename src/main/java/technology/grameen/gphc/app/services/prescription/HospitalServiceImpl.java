package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.prescription.Hospital;
import technology.grameen.gphc.app.healthapp.repositories.HospitalRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    @Transactional
    public void addHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public Page<?> getHospitals(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }

    @Override
    public List<?> getHospitals(String name) {
        if(name.isEmpty()){
            return hospitalRepository.findAll();
        }

        return hospitalRepository.findAllByTitle(name);
    }

    @Override
    public Optional<?> getHospitalById(String id) {
        return hospitalRepository.findById(UUID.fromString(id));
    }
}
