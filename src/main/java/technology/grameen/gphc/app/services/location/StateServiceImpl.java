package technology.grameen.gphc.app.services.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.healthapp.repositories.GeoStateRepository;

import java.util.List;

@Service
public class StateServiceImpl implements StateService{

    @Autowired
    private GeoStateRepository stateRepository;

    @Override
    public List<?> getStates(String name) {
        return stateRepository.findAllByCountryShortCodeContainingIgnoreCase(name);
    }
}
