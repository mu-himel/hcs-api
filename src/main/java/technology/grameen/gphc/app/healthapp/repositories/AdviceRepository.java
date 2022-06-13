package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.prescription.Advice;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, UUID> {


    Optional<Advice> findByTitle(String title);
}
