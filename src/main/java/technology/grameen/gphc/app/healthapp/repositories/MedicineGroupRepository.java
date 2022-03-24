package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicineGroupRepository extends JpaRepository<MedicineGroup, UUID> {
    List<MedicineGroup> findByName(String name);

    Integer countByName(String name);
}
