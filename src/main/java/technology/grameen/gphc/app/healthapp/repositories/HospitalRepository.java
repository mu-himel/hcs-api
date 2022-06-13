package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.prescription.Hospital;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, UUID> {

    List<?> findAllByTitle(String name);

    Optional<Hospital> findByTitleIgnoreCase(String title);
}
