package technology.grameen.gphc.app.services.location;

import technology.grameen.gphc.app.entity.GeoCity;

import java.util.List;

public interface CityService {

    List<?> getCities(String name);
}
