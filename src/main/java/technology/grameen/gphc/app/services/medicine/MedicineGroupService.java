package technology.grameen.gphc.app.services.medicine;

import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;

import java.util.List;

public interface MedicineGroupService {

    List<MedicineGroup> getMedicineGroupsByName(String name);
}
