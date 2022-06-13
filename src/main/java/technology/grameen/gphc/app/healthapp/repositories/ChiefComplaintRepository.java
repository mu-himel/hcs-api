package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChiefComplaintRepository extends JpaRepository<ChiefComplaint, UUID> {
    
    Optional<ChiefComplaint> findByTitleIgnoreCase(String title);
}
