package technology.grameen.gphc.app.services.location;

import technology.grameen.gphc.app.entity.GeoCountry;

import java.util.List;

public interface CountryService {
    List<GeoCountry> getCountries(String name);
}
