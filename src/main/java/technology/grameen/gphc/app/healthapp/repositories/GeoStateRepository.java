package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.GeoState;

import java.util.List;

@Repository
public interface GeoStateRepository extends JpaRepository<GeoState,Long> {

    interface Country{
        Long getId();
        String getName();
    }

    interface State{
        Long getId();
        String getName();
        String getCountryShortCode();
        Country getCountry();
    }

    @Query(value = "SELECT gs FROM GeoState gs " +
            "JOIN FETCH gs.country c WHERE lower(gs.name) LIKE concat( lower(:name) || '%')")
    List<State> findAllByNameContainingIgnoreCase(@Param("name") String name);
}
