package technology.grameen.gphc.app.services.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.entity.site.SiteService;
import technology.grameen.gphc.app.healthapp.repositories.SiteServiceRepository;

import java.util.List;

@Service
public class SiteHealthServiceImpl implements SiteHealthService{

    @Autowired
    private SiteServiceRepository siteServiceRepository;

    @Override
    @Transactional
    public void add(List<SiteService> siteServices) throws CustomException {
        if(siteServices.size()==0){
            throw new CustomException("No Data found to save");
        }
        for(SiteService siteService : siteServices)  {
            if(siteService.getService() != null && siteService.getService().getId() == null){
                throw new CustomException("Service Id is missing");
            }
            if(siteService.getSite() != null && siteService.getSite().getId() == null){
                throw new CustomException("Site Id is missing");
            }
        }
        siteServiceRepository.deleteBySite(siteServices.get(0).getSite());
        siteServiceRepository.saveAll(siteServices);
    }

    @Override
    public List<?> getHealthServices(Site site) {
        return siteServiceRepository.findBySite(site);
    }
}
