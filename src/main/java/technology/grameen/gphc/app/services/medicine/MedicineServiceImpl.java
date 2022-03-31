package technology.grameen.gphc.app.services.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;
import technology.grameen.gphc.app.healthapp.repositories.MedicineRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicineServiceImpl implements MedicineService{

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getMedicineListByName(String name) {
        if(name.isEmpty()){
            return medicineRepository.findAll();
        }
        return medicineRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional
    public Medicine addMedicine(Medicine medicine) throws CustomException {
        if(medicine.getCreatedAt()==null) {
            Integer exist = medicineRepository.countByNameAndMedicineGroup(medicine.getName(),
                    medicine.getMedicineGroup());
            if (exist > 0) {
                throw new CustomException("Medicine already exist under same group, Please try something else");
            }
        }
        return medicineRepository.save(medicine);
    }

    @Override
    public Page<Medicine> getMedicineByName(String name, Pageable pageable) {
        if(name.isEmpty()){
            medicineRepository.findAll(pageable);
        }
        return medicineRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public Optional<?> getMedicineById(String id) {
        return medicineRepository.findById(UUID.fromString(id));
    }
}
