package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SiteService;
import technology.grameen.gphc.app.healthapp.entity.service.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SiteServiceRepository extends JpaRepository<SiteService, UUID> {

    @Query("SELECT ss FROM SiteService ss " +
            "JOIN FETCH ss.site s1 " +
            "JOIN FETCH ss.service s2 " +
            "WHERE s1 = :site AND s2 = :service")
    Optional<?> findBySiteAndService(@Param("site") Site site, @Param("service") Service service);

    interface SiteServiceInfo{
        ServiceInfo getService();
        BigDecimal getPrice();
        BigDecimal getRevisitPrice();
        UUID getId();
    }

    interface ServiceInfo {
        UUID getId();
        String getName();
    }

    @Query("SELECT ss FROM SiteService ss " +
            "JOIN FETCH ss.site s1 " +
            "JOIN FETCH ss.service s2 " +
            "WHERE s1 = :site")
    List<SiteServiceInfo> findBySite(@Param("site") Site site);

    @Modifying
    @Query("DELETE FROM SiteService ss WHERE ss.site = :site")
    void deleteBySite(@Param("site") Site site);
}
