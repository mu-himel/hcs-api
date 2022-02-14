package technology.grameen.gphc.app.services.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.Site;
import technology.grameen.gphc.app.healthapp.repositories.SiteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SiteServiceImpl implements SiteService{

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SiteUserService siteUserService;

    @Override
    public Page<Site> getAll(Pageable pageable) {
        return siteRepository.findAll(pageable);
    }

    @Override
    public List<Site> getAll() {
        return siteRepository.findAll();
    }

    @Override
    public SiteUserService getSiteUser() {
        return siteUserService;
    }

    @Override
    public Optional<?> getSiteById(String id) {
        return siteRepository.findSiteById(UUID.fromString(id));
    }

    @Override
    @Transactional
    public Site addSite(Site site) throws CustomException {
        if(site.getCountry() == null){
            throw new CustomException("Country not found");
        }



        return siteRepository.save(site);
    }
}
