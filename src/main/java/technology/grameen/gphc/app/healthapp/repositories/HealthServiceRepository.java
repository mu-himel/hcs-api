package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.service.Service;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;

import java.util.List;
import java.util.UUID;

@Repository
public interface HealthServiceRepository extends JpaRepository<Service, UUID> {

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc")
    List<?> findAllServices();

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc" +
            " WHERE lower(s.name) LIKE lower(concat('%',:serviceName,'%'))",
            countQuery = "SELECT COUNT(s) FROM Service s JOIN s.serviceCategory sc " +
                    " WHERE lower(s.name) LIKE lower(concat('%',:serviceName,'%'))")
    Page<?> findAllServices(@Param("serviceName") String serviceName, Pageable pageable);

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc",
            countQuery = "SELECT COUNT(s) FROM Service s JOIN s.serviceCategory sc")
    Page<?> findAllServices(Pageable pageable);

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc" +
            " WHERE lower(s.code) LIKE lower(concat('%',:serviceCode,'%'))",
            countQuery = "SELECT COUNT(s) FROM Service s JOIN s.serviceCategory sc " +
                    " WHERE lower(s.code) LIKE lower(concat('%',:serviceCode,'%'))")
    Page<?> findAllServicesByCode(@Param("serviceCode") String serviceCode, Pageable pageable);

    interface IServiceList{
        UUID getId();
        String getName();
        String getCode();
    }
    List<IServiceList> findByServiceCategory(ServiceCategory serviceCategory);
}
