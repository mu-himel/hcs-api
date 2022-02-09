package technology.grameen.gphc.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.healthapp.entity.GeoCountry;
import technology.grameen.gphc.app.healthapp.repositories.GeoCountryRepository;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private GeoCountryRepository countryRepository;

    @Override
    public List<GeoCountry> getCountries(String name) {
        return countryRepository.findAllByNameContainingIgnoreCase(name);
    }
}
