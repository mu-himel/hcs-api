package technology.grameen.gphc.app.services.medicine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;
import technology.grameen.gphc.app.healthapp.repositories.MedicineGroupRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicineGroupServiceImpl implements MedicineGroupService{

    @Autowired
    private MedicineGroupRepository medicineGroupRepository;

    @Override
    @Transactional
    public void add(MedicineGroup medicineGroup) throws CustomException {

        Optional<MedicineGroup> opMedicineGroup = medicineGroupRepository
                .findByNameIgnoreCase(medicineGroup.getName());
        if(medicineGroup.getId() != null){

            if(opMedicineGroup.isPresent()) {
                if (!medicineGroup.getId().equals(opMedicineGroup.get().getId())) {
                    throw new CustomException("Medicine Group with name "+medicineGroup.getName()+" already exist");
                }
            }
        }

        if(medicineGroup.getId() == null) {
            if(opMedicineGroup.isPresent()) {
                throw new CustomException("Medicine Group already with name "+medicineGroup.getName()+" exist");
            }
        }

        opMedicineGroup = medicineGroupRepository
                .findByAliasIgnoreCase(medicineGroup.getAlias());
        if(medicineGroup.getId() != null){

            if(opMedicineGroup.isPresent()) {
                if (!medicineGroup.getId().equals(opMedicineGroup.get().getId())) {
                    throw new CustomException("Medicine Group with alias "+medicineGroup.getAlias()+" already exist");
                }
            }
        }

        if(medicineGroup.getId() == null) {
            if(opMedicineGroup.isPresent()) {
                throw new CustomException("Medicine Group with alias "+medicineGroup.getAlias()+" already exist");
            }
        }

        if(medicineGroup.getId() == null){
            medicineGroup.setId(UUID.randomUUID());
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

    @Override
    public Optional<?> getMedicineGroupsById(UUID id) {
        return medicineGroupRepository.findById(id);
    }

    @Override
    public Page<MedicineGroup> getMedicineGroupsByName(String name, Pageable pageable) {
        if(name.isEmpty()){
            return medicineGroupRepository.findAll(pageable);
        }
        return medicineGroupRepository.findByNameContainingIgnoreCase(name,pageable);
    }
}
