package technology.grameen.gphc.app.services.medicine;

import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;
import technology.grameen.gphc.app.healthapp.repositories.MedicineGroupRepository;

import java.util.List;

@Service
public class MedicineGroupServiceImpl implements MedicineGroupService{

    private MedicineGroupRepository medicineGroupRepository;

    @Override
    public List<MedicineGroup> getMedicineGroupsByName(String name) {
        return medicineGroupRepository.findByName(name);
    }
}
