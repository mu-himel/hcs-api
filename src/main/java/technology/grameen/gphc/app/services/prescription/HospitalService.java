package technology.grameen.gphc.app.services.prescription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalService {

    void addHospital(Hospital hospital) throws CustomException;
    Page<?> getHospitals(Pageable pageable);
    List<?> getHospitals(String name);
    Optional<?> getHospitalById(String id);
}
