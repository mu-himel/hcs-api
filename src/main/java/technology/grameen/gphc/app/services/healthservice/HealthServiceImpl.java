package technology.grameen.gphc.app.services.healthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.service.Service;
import technology.grameen.gphc.app.healthapp.entity.service.ServiceCategory;
import technology.grameen.gphc.app.healthapp.repositories.HealthServiceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class HealthServiceImpl implements HealthService{

    @Autowired
    private HealthServiceRepository healthServiceRepository;

    @Override
    public Service addService(Service service) {
        service.setCode(service.getName().toLowerCase().replaceAll(" ","-"));
        return healthServiceRepository.save(service);
    }

    @Override
    public Optional<?> findServiceById(UUID id) {
        Optional<?> serviceRes = healthServiceRepository.findServiceById(id);
        return serviceRes;
    }

    @Override
    public List<?> getAll() {
        return healthServiceRepository.findAllServices();
    }

    @Override
    public Page<?> getAll(String serviceName, String serviceCode, Pageable pageable) {
        if(!serviceName.isEmpty()) {
            return healthServiceRepository.findAllServices(serviceName, pageable);
        }
        if(!serviceCode.isEmpty()) {
            return healthServiceRepository.findAllServicesByCode(serviceCode, pageable);
        }

        if(serviceName.isEmpty() && serviceCode.isEmpty()){
            return healthServiceRepository.findAllServices(pageable);
        }

        return null;
    }

    @Override
    public List<?> findByServiceCategory(ServiceCategory serviceCategory) {
        return healthServiceRepository.findByServiceCategory(serviceCategory);
    }
}
