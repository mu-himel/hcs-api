package technology.grameen.gphc.app.services.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.SiteUser;
import technology.grameen.gphc.app.healthapp.repositories.SiteUserRepository;

import java.util.List;

@Service
public class SiteUserServiceImpl implements SiteUserService{

    @Autowired
    private SiteUserRepository siteUserRepository;

    @Override
    @Transactional
    public void assignUser(List<SiteUser> siteUsers) {
        siteUserRepository.saveAll(siteUsers);
    }

    @Override
    public List<?> getUsers() {
        return siteUserRepository.getUsers();
    }
}
