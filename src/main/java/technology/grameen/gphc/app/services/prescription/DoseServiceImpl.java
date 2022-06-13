package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.Dose;
import technology.grameen.gphc.app.healthapp.repositories.DoseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoseServiceImpl implements DoseService{

    @Autowired
    private DoseRepository doseRepository;

    @Override
    @Transactional
    public void addDose(Dose dose) throws CustomException {

        Optional<Dose> doseOptional = doseRepository.findByTitleIgnoreCase(dose.getTitle());
        if(dose.getId() != null && doseOptional.isPresent()){
            if(!dose.getId().equals(doseOptional.get().getId())){
                throw new CustomException("Dose already exist with title "+ dose.getTitle());
            }
        }

        if(dose.getId() == null && doseOptional.isPresent()){
            throw new CustomException("Dose already exist with title "+ dose.getTitle());
        }

        if(dose.getId() == null){
            dose.setId(UUID.randomUUID());
        }
        doseRepository.save(dose);
    }

    @Override
    public List<Dose> getDoses() {
        return doseRepository.findAll();
    }
}
