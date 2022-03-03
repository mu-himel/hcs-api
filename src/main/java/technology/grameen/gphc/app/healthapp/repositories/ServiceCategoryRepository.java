package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, UUID> {

    Page<?> findAllByNameContainingIgnoreCase(String categoryName, Pageable pageable);

    interface IServiceCategory{
        Long getId();
        String getName();
        String getCode();
    }
    Optional<IServiceCategory> findByCodeIgnoreCase(String code);
}
