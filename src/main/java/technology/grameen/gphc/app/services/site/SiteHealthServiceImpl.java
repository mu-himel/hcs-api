package technology.grameen.gphc.app.services.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SiteService;
import technology.grameen.gphc.app.healthapp.repositories.SiteServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiteHealthServiceImpl implements SiteHealthService{

    @Autowired
    private SiteServiceRepository siteServiceRepository;

    @Override
    @Transactional
    public void add(SiteService siteService) throws CustomException {

        if(siteService.getService() != null && siteService.getService().getId() == null){
            throw new CustomException("Service Id is missing");
        }
        if(siteService.getSite() != null && siteService.getSite().getId() == null){
            throw new CustomException("Site Id is missing");
        }

        Optional<?> siteAndServiceOp = getHealthServiceBySiteAndService(siteService.getSite(), siteService.getService());
        if(siteAndServiceOp.isPresent()){
            throw new CustomException("Service already added to the site");
        }
        siteServiceRepository.save(siteService);
    }

    @Override
    public List<?> getHealthServices(Site site) {
        return siteServiceRepository.findBySite(site);
    }

    @Override
    public Optional<?> getHealthServiceBySiteAndService(Site site, technology.grameen.gphc.app.healthapp.entity.service.Service service) {
        return siteServiceRepository.findBySiteAndService(site, service);
    }
}
