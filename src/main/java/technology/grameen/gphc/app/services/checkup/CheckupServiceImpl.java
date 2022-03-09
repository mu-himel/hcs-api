package technology.grameen.gphc.app.services.checkup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.checkup.BasicCheckup;
import technology.grameen.gphc.app.healthapp.repositories.BasicCheckupRepository;

@Service
public class CheckupServiceImpl implements CheckupService{

    @Autowired
    private BasicCheckupRepository checkupRepository;

    @Override
    @Transactional
    public BasicCheckup add(BasicCheckup checkup) {
        return checkupRepository.save(checkup);
    }
}
