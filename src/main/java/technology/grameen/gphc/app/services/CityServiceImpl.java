package technology.grameen.gphc.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.healthapp.repositories.GeoCityRepository;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private GeoCityRepository cityRepository;

    @Override
    public List<?> getCities(String name) {
        return cityRepository.findAllByNameContainingIgnoreCase(name);
    }
}
