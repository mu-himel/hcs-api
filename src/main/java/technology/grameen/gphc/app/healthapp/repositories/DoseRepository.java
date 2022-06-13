package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.prescription.Dose;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoseRepository extends JpaRepository<Dose, UUID> {

    Optional<Dose> findByTitleIgnoreCase(String title);
}
