package technology.grameen.gphc.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.entity.GeoCountry;

import java.util.List;
import java.util.UUID;

@Repository
public interface GeoCountryRepository extends JpaRepository<GeoCountry, Long> {

    List<GeoCountry> findAllByNameContainingIgnoreCase(String s);
}
