package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicineGroupRepository extends JpaRepository<MedicineGroup, UUID> {
    List<MedicineGroup> findByName(String name);

    Integer countByName(String name);


    Page<MedicineGroup> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
