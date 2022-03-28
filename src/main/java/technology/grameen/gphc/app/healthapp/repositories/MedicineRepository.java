package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.medicine.Medicine;
import technology.grameen.gphc.app.healthapp.entity.medicine.MedicineGroup;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, UUID> {
    List<Medicine> findByNameContainingIgnoreCase(String name);

    Integer countByNameAndMedicineGroup(String name, MedicineGroup medicineGroup);

    @Query(value = "SELECT m FROM Medicine m JOIN FETCH m.medicineGroup mg " +
            "WHERE lower(m.name) LIKE '%' || lower(:name) || '%'",
    countQuery = "SELECT m FROM Medicine m JOIN m.medicineGroup mg " +
            "WHERE lower(m.name) LIKE '%' || lower(:name) || '%'")
    Page<Medicine> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT m FROM Medicine m JOIN FETCH m.medicineGroup mg ",
            countQuery = "SELECT m FROM Medicine m JOIN m.medicineGroup mg ")
    Page<Medicine> findAll(Pageable pageable);
}
