package technology.grameen.gphc.app.services.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.site.SiteUser;
import technology.grameen.gphc.app.healthapp.repositories.SiteUserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class SiteUserServiceImpl implements SiteUserService{

    @Autowired
    private SiteUserRepository siteUserRepository;

    @Override
    @Transactional
    public void assignUser(List<SiteUser> siteUsers) throws CustomException {
        if(siteUsers.size()==0){
            throw new CustomException("No Data found to save");
        }
        siteUserRepository.saveAll(siteUsers);
    }

    @Override
    public List<?> getUsers(UUID siteId) {
        return siteUserRepository.getUsers(siteId);
    }

    @Override
    public List<?> getSitesByUserId(String id) {
        return siteUserRepository.getSitesByUserId(id);
    }
}
