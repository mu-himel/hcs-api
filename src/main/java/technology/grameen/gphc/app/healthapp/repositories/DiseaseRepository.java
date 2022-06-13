package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.prescription.Disease;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, UUID> {

    Optional<Disease> findByTitleIgnoreCase(String title);
}
