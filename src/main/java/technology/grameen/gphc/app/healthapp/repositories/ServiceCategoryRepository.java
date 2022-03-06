package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, UUID> {

    @Query(value = "SELECT sc FROM ServiceCategory sc")
    List<IServiceCategory> findServiceCategoriesAll();

    Page<ServiceCategory> findAllByNameContainingIgnoreCase(String categoryName, Pageable pageable);


    Optional<ServiceCategory> findServiceCategoryById(UUID id);

    interface ServiceCategory {
        UUID getId();
        String getName();
        String getCode();
        String getDescription();
        IServiceCategory getParent();
    }
    @Query(value = "SELECT sc FROM ServiceCategory sc")
    Page<ServiceCategory> findServiceCategoriesAll(Pageable pageable);

    interface IServiceCategory{
        UUID getId();
        String getName();
        String getCode();
    }
    Optional<IServiceCategory> findByCodeIgnoreCase(String code);
}
