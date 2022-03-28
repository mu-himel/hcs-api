package technology.grameen.gphc.app.services.medicine;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;

import java.util.List;

public interface MedicineService {

    List<Medicine> getMedicineListByName(String name);

    Medicine addMedicine(Medicine medicine) throws CustomException;

    Page<Medicine> getMedicineByName(String orElse, Pageable pageable);
}
