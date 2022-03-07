package technology.grameen.gphc.app.services.healthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
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
        return serviceCategoryRepository.findServiceCategoriesAll();
    }

    @Override
    public Page<?> getCategories(String categoryName, Pageable pageable) {
        if(categoryName.isEmpty()){
            return serviceCategoryRepository.findServiceCategoriesAll(pageable);
        }
        return serviceCategoryRepository.findAllByNameContainingIgnoreCase(categoryName,pageable);
    }

    @Override
    @Transactional
    public ServiceCategory addCategory(ServiceCategory serviceCategory) throws CustomException {

        serviceCategory.setCode(serviceCategory.getName().toLowerCase().replaceAll(" ","-"));
        Optional<?> categoryOp = findByCode(serviceCategory.getCode());
        if(serviceCategory.getId() == null && categoryOp.isPresent()){
            throw new CustomException("Service Category already exist with name " + serviceCategory.getName());
        }
        if(serviceCategory.getId() == null) {
            serviceCategory.setId(UUID.randomUUID());
        }
        serviceCategoryRepository.save(serviceCategory);
        return serviceCategory;
    }

    @Override
    public Optional<?> findById(UUID id) {
        return serviceCategoryRepository.findServiceCategoryById(id);
    }

    @Override
    public Optional<?> findByCode(String code) {
        return serviceCategoryRepository.findByCodeIgnoreCase(code);
    }
}
