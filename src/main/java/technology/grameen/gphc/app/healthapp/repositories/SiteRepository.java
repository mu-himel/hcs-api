package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.site.Site;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SiteRepository extends JpaRepository<Site, UUID> {

    @Query(value = "SELECT s FROM Site s " +
            "LEFT JOIN FETCH s.country co" +
            "LEFT JOIN FETCH s.city ci " +
            "LEFT JOIN FETCH s.state st " +
            "WHERE lower(s.title) LIKE concat('%' || lower(:name) || '%') ORDER BY s.createdAt DESC,s.title DESC" ,
            countQuery = "SELECT count(s) FROM Site s " +
                    "LEFT JOIN s.country co" +
                    "LEFT JOIN s.city ci " +
                    "LEFT JOIN s.state st " +
                    "WHERE lower(s.title) LIKE concat('%' || lower(:name) || '%')")
    Page<?> findAllSitesByTitle(@Param("name") String name, Pageable pageable);

    interface SiteInfo{
        UUID getId();
        String getTitle();
        String getAlias();
        String getDescription();
        String getAddress1();
        String getAddress2();
        String getEmail();
        String getContactNumber();
        String getLongitude();
        String getLatitude();
        String getPostalCode();
        String getLogo();
        Boolean getShowLogoInPrescription();
        Boolean getShowSiteHeader();
        Boolean getHideAllReportHeader();
        Boolean getAutoBarCodeGenerationEnabled();
        Boolean getActive();

        @JsonFormat(pattern = "yyyy-mm-dd")
        LocalDateTime getCreatedAt();

        @JsonFormat(pattern = "yyyy-mm-dd")
        LocalDateTime getUpdatedAt();
        GeoCountry getCountry();
        GeoCity getCity();
        GeoState getState();
    }
    interface GeoCountry{
        Long getId();
        String getIso2();
        String getName();
    }

    interface GeoCity{
        Long getId();
        String getName();
    }

    interface GeoState{
        Long getId();
        String getName();
    }

    @Query(value = "SELECT s FROM Site s " +
            "LEFT JOIN FETCH s.country co " +
            "LEFT JOIN FETCH s.city ci " +
            "LEFT JOIN FETCH s.state st " +
            "WHERE s.id = :id")
    Optional<SiteInfo> findSiteById(@Param("id") UUID siteId);

    @Query(value = "SELECT s FROM Site s " +
            "LEFT JOIN FETCH s.country co" +
            "LEFT JOIN FETCH s.city ci " +
            "LEFT JOIN FETCH s.state st ORDER BY s.createdAt DESC,s.title DESC" ,
    countQuery = "SELECT count(s) FROM Site s " +
            "LEFT JOIN s.country co" +
            "LEFT JOIN s.city ci " +
            "LEFT JOIN s.state st ")
    Page<SiteInfo> findAllSites(Pageable pageable);

    @Query(value = "SELECT s FROM Site s " +
            "LEFT JOIN FETCH s.country co" +
            "LEFT JOIN FETCH s.city ci " +
            "LEFT JOIN FETCH s.state st ORDER BY s.createdAt DESC,s.title DESC")
    List<SiteInfo> findAllSites();
}
