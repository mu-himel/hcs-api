package technology.grameen.gphc.app.services.healthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
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
    @Transactional
    public Service addService(Service service) throws CustomException {

        if(service.getCode() == null || service.getCode().isEmpty()){
            throw new CustomException("Service code is required");
        }

        Optional<HealthServiceRepository.ServiceDetail> serviceOp = findByName(service.getName());
        if(service.getId()!=null && serviceOp.isPresent()){
            if(!service.getId().equals(serviceOp.get().getId())){
                throw new CustomException("Service name "+service.getName()+" already exist");
            }
        }
        if(service.getId() == null && serviceOp.isPresent()){
            throw new CustomException("Service Name "+service.getName()+" already exist");
        }

        serviceOp = findByCode(service.getCode());
        if(service.getId()!=null && serviceOp.isPresent()){
            if(!service.getId().equals(serviceOp.get().getId())){
                throw new CustomException("Service Code "+service.getCode()+" already exist");
            }
        }
        if(service.getId() == null && serviceOp.isPresent()){
            throw new CustomException("Service Code "+service.getCode()+" already exist");
        }


        if(service.getId() == null){
            service.setId(UUID.randomUUID());
        }
        return healthServiceRepository.save(service);
    }

    @Override
    public Optional<?> findServiceById(UUID id) {
        Optional<?> serviceRes = healthServiceRepository.findServiceById(id);
        return serviceRes;
    }

    @Override
    public Optional<HealthServiceRepository.ServiceDetail> findByCode(String code) {
        Optional<HealthServiceRepository.ServiceDetail> codeOp = healthServiceRepository.findByCode(code);
        return codeOp;
    }

    @Override
    public Optional<HealthServiceRepository.ServiceDetail> findByName(String name) {
        Optional<HealthServiceRepository.ServiceDetail> nameOp = healthServiceRepository.findByName(name);
        return nameOp;
    }

    @Override
    public List<?> getAll() {
        return healthServiceRepository.findAllServices();
    }

    @Override
    public Page<?> getAll(String name, Pageable pageable) {
        if(!name.isEmpty()) {
            return healthServiceRepository.findAllServices(name, pageable);
        }

        return healthServiceRepository.findAllServices(pageable);

    }

    @Override
    public List<?> findByServiceCategory(ServiceCategory serviceCategory) {
        return healthServiceRepository.findByServiceCategory(serviceCategory);
    }
}
