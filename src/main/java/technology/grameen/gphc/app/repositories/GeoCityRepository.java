package technology.grameen.gphc.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.entity.GeoCity;

import java.util.List;

@Repository
public interface GeoCityRepository extends JpaRepository<GeoCity,Long> {

    interface Country{
        Long getId();
        String getName();
    }

    interface City{
        Long getId();
        String getName();
        String getLongitude();
        String getLatitude();
        Country getCountry();
    }

    @Query(value = "SELECT gc FROM GeoCity gc " +
            "JOIN FETCH gc.country c " +
            "WHERE lower(gc.name) LIKE CONCAT( lower(:name) || '%' )")
    List<City> findAllByNameContainingIgnoreCase(String name);
}
