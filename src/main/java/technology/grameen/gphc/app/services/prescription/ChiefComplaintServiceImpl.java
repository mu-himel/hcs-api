package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;
import technology.grameen.gphc.app.healthapp.repositories.ChiefComplaintRepository;

import java.util.List;

@Service
public class ChiefComplaintServiceImpl implements ChiefComplaintService{

    @Autowired
    private ChiefComplaintRepository chiefComplaintRepository;

    @Override
    @Transactional
    public void add(ChiefComplaint chiefComplaint) {
        chiefComplaintRepository.save(chiefComplaint);
    }

    @Override
    public List<ChiefComplaint> getAll() {
        return chiefComplaintRepository.findAll();
    }
}
