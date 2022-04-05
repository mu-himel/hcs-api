package technology.grameen.gphc.app.services.checkup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.checkup.BasicCheckup;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.repositories.BasicCheckupRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CheckupServiceImpl implements CheckupService{

    @Autowired
    private BasicCheckupRepository checkupRepository;

    @Override
    @Transactional
    public BasicCheckup add(BasicCheckup checkup) {
        return checkupRepository.save(checkup);
    }

    @Override
    public List<?> getPatientCheckup(String id) {
        Profile profile = new Profile();
        profile.setId(UUID.fromString(id));
        return checkupRepository.findByProfile(profile);
    }

    @Override
    public Optional<?> getPatientCheckupById(String id) {
        return checkupRepository.findCheckupDataById(UUID.fromString(id));
    }

    @Override
    @Transactional
    public void updateCheckupAsPrescribed(BasicCheckup checkup) {
        Optional<BasicCheckup> checkupOp = checkupRepository.findById(checkup.getId());
        if(checkupOp.isPresent()) {
            BasicCheckup ch = checkupOp.get();
            ch.setPrescribed(true);
            checkupRepository.save(ch);
        }

    }
}
