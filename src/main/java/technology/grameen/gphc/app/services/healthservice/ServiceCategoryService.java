package technology.grameen.gphc.app.services.healthservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceCategoryService {

    List<?> getCategories();

    Page<?> getCategories(String categoryName, Pageable pageable);

    ServiceCategory addCategory(ServiceCategory serviceCategory) throws CustomException;

    Optional<?> findById(UUID id);

    Optional<?> findByCode(String code);
}
