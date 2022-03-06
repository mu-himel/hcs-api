package technology.grameen.gphc.app.services.site;

import technology.grameen.gphc.app.healthapp.entity.SiteUser;

import java.util.List;
import java.util.UUID;

public interface SiteUserService {

   void assignUser(List<SiteUser> siteUsers);

   List<?> getUsers(UUID siteId);
}
