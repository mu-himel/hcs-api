package technology.grameen.gphc.app.services.medicine;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> getMedicineListByName(String name);

    Medicine addMedicine(Medicine medicine) throws CustomException;
}
