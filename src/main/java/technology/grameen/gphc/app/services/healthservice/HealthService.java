package technology.grameen.gphc.app.services.healthservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.service.Service;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HealthService {

    Service addService(Service service) throws CustomException;


    Optional<?> findServiceById(UUID id);
    Optional<?> findByCode(String code);

    List<?> getAll();
    Page<?> getAll(String serviceName, String serviceCode, Pageable pageable);

    List<?> findByServiceCategory(ServiceCategory serviceCategory);
}
