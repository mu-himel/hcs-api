package technology.grameen.gphc.app.services.medicine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;

import java.util.List;

public interface MedicineGroupService {

    List<MedicineGroup> getMedicineGroupsByName(String name);

    void add(MedicineGroup medicineGroup) throws CustomException;

    Page<MedicineGroup> getMedicineGroupsByName(String orElse, Pageable pageable);
}
