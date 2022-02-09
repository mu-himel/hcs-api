package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.GeoCountry;

import java.util.List;

@Repository
public interface GeoCountryRepository extends JpaRepository<GeoCountry, Long> {

    List<GeoCountry> findAllByNameContainingIgnoreCase(String s);
}
