package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.configuration.TriageConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TriageConfigRepository extends JpaRepository<TriageConfiguration, UUID> {
    List<TriageConfiguration> findByTriageFor(String triageFor);

    @Query(value = "SELECT t FROM TriageConfiguration t " +
            "WHERE lower(t.paramName) LIKE '%' || lower(:paramName) || '%'")
    Page<TriageConfiguration> findAllByParamName(Pageable pageable,
                                                 @Param("paramName") String paramName);

    Optional<TriageConfiguration> findByParamName(String paramName);
    Optional<TriageConfiguration> findByAlias(String alias);
}
