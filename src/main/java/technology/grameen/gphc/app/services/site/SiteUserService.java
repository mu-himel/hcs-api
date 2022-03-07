package technology.grameen.gphc.app.services.site;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.site.SiteUser;

import java.util.List;
import java.util.UUID;

public interface SiteUserService {

   void assignUser(List<SiteUser> siteUsers) throws CustomException;

   List<?> getUsers(UUID siteId);
}
