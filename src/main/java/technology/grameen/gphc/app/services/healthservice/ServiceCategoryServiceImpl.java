package technology.grameen.gphc.app.services.healthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;
import technology.grameen.gphc.app.healthapp.repositories.ServiceCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService{

    @Autowired
    private ServiceCategoryRepository serviceCategoryRepository;

    @Override
    public List<?> getCategories() {
        return serviceCategoryRepository.findAll();
    }

    @Override
    public Page<?> getCategories(String categoryName, Pageable pageable) {
        if(categoryName.isEmpty()){
            return serviceCategoryRepository.findAll(pageable);
        }
        return serviceCategoryRepository.findAllByNameContainingIgnoreCase(categoryName,pageable);
    }

    @Override
    public ServiceCategory addCategory(ServiceCategory serviceCategory) {
        serviceCategory.setCode(serviceCategory.getName().toLowerCase().replaceAll(" ","-"));
        serviceCategoryRepository.save(serviceCategory);
        return serviceCategory;
    }

    @Override
    public Optional<ServiceCategory> findById(UUID id) {
        return serviceCategoryRepository.findById(id);
    }

    @Override
    public Optional<?> findByCode(String code) {
        return serviceCategoryRepository.findByCodeIgnoreCase(code);
    }
}
