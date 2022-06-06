package technology.grameen.gphc.app.services.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.subscription.SubscriptionPackage;
import technology.grameen.gphc.app.healthapp.repositories.SubscriptionPackageRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PackageServiceImpl implements PackageService{

    @Autowired
    private SubscriptionPackageRepository subscriptionPackageRepository;

    @Override
    @Transactional
    public void addPackage(SubscriptionPackage subscriptionPackage) {
        SubscriptionPackage sp = subscriptionPackageRepository.save(subscriptionPackage);
        sp.getServices().stream().forEach(s->{
            s.addPackage(sp);
        });
    }

    @Override
    @Transactional
    public void updatePackage(String id, SubscriptionPackage subscriptionPackage) {
        Optional<?> op = getPackageById(id);
        if(op.isPresent()){
            SubscriptionPackage sp = subscriptionPackageRepository.save(subscriptionPackage);
            sp.getServices().stream().forEach(s->{
                s.addPackage(sp);
            });
        }
    }

    @Override
    public Optional<?> getPackageById(String id) {
        return subscriptionPackageRepository.findPackageById(UUID.fromString(id));
    }

    @Override
    public Page<?> getAll(String name, Pageable pageable) {
        if(!name.isEmpty()){
            return subscriptionPackageRepository.findAllPackagesByName(name,pageable);
        }
        return subscriptionPackageRepository.findAllPackages(pageable);
    }

    @Override
    public List<?> getAll(String name) {
        if(!name.isEmpty()){
            return subscriptionPackageRepository.findAllPackagesByName(name);
        }
        return subscriptionPackageRepository.findAllPackages();
    }
}
