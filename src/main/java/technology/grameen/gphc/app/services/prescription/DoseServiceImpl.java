package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.prescription.Dose;
import technology.grameen.gphc.app.healthapp.repositories.DoseRepository;

import java.util.List;

@Service
public class DoseServiceImpl implements DoseService{

    @Autowired
    private DoseRepository doseRepository;

    @Override
    @Transactional
    public void addDose(Dose dose) {
        doseRepository.save(dose);
    }

    @Override
    public List<Dose> getDoses() {
        return doseRepository.findAll();
    }
}
