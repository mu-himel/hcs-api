package technology.grameen.gphc.app.services.site;

import technology.grameen.gphc.app.healthapp.entity.SiteUser;

import java.util.List;

public interface SiteUserService {

   void assignUser(List<SiteUser> siteUsers);

   List<?> getUsers();
}
