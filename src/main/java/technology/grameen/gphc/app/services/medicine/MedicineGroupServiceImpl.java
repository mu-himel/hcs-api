package technology.grameen.gphc.app.services.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;
import technology.grameen.gphc.app.healthapp.repositories.MedicineGroupRepository;

import java.util.List;

@Service
public class MedicineGroupServiceImpl implements MedicineGroupService{

    @Autowired
    private MedicineGroupRepository medicineGroupRepository;

    @Override
    @Transactional
    public void add(MedicineGroup medicineGroup) throws CustomException {
        Integer exist = medicineGroupRepository.countByName(medicineGroup.getName());
        if(exist>0){
            throw new CustomException("Medicine Group already exist");
        }
        medicineGroupRepository.save(medicineGroup);
    }

    @Override
    public List<MedicineGroup> getMedicineGroupsByName(String name) {
        if(name.isEmpty()){
            return medicineGroupRepository.findAll();
        }
        return medicineGroupRepository.findByName(name);
    }
}
