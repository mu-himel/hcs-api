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
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HealthServiceRepository extends JpaRepository<Service, UUID> {

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc")
    List<ServiceDetail> findAllServices();

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc" +
            " WHERE lower(s.name) LIKE lower(concat('%',:serviceName,'%'))",
            countQuery = "SELECT COUNT(s) FROM Service s JOIN s.serviceCategory sc " +
                    " WHERE lower(s.name) LIKE lower(concat('%',:serviceName,'%'))")
    Page<ServiceDetail> findAllServices(@Param("serviceName") String serviceName, Pageable pageable);

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc",
            countQuery = "SELECT COUNT(s) FROM Service s JOIN s.serviceCategory sc")
    Page<ServiceDetail> findAllServices(Pageable pageable);

    @Query(value = "SELECT s FROM Service s JOIN FETCH s.serviceCategory sc" +
            " WHERE lower(s.code) LIKE lower(concat('%',:serviceCode,'%'))",
            countQuery = "SELECT COUNT(s) FROM Service s JOIN s.serviceCategory sc " +
                    " WHERE lower(s.code) LIKE lower(concat('%',:serviceCode,'%'))")
    Page<ServiceDetail> findAllServicesByCode(@Param("serviceCode") String serviceCode, Pageable pageable);

    interface ServiceDetailServiceCategory{
        UUID getId();
        String getName();
    }

    interface ServiceDetail{
        UUID getId();
        String getName();
        String getCode();
        String getDescription();
        ServiceDetailServiceCategory getServiceCategory();
    }
    Optional<ServiceDetail> findServiceById(UUID id);

    interface IServiceList{
        UUID getId();
        String getName();
        String getCode();
    }
    List<IServiceList> findByServiceCategory(ServiceCategory serviceCategory);
}
