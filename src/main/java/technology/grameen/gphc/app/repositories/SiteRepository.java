package technology.grameen.gphc.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.entity.Site;

import java.util.UUID;

@Repository
public interface SiteRepository extends JpaRepository<Site, UUID> {
}
