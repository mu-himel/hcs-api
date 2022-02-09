package technology.grameen.gphc.app.services.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.Site;
import technology.grameen.gphc.app.healthapp.repositories.SiteRepository;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService{

    @Autowired
    private SiteRepository siteRepository;

    @Override
    public Page<Site> getAll(Pageable pageable) {
        return siteRepository.findAll(pageable);
    }

    @Override
    public List<Site> getAll() {
        return siteRepository.findAll();
    }

    @Override
    @Transactional
    public Site addSite(Site site) {
        return siteRepository.save(site);
    }
}
