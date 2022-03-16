package technology.grameen.gphc.app.services.ehr;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompositionServiceImpl implements CompositionService{

    @Override
    public void addEhr(Map<String, ?> composition) {

    }

    @Override
    public List<?> getAllEhr() {
        return null;
    }

    @Override
    public Optional<?> getEhrByPatient(String patientId) {
        return Optional.empty();
    }
}
