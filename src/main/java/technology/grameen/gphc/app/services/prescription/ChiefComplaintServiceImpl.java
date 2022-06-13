package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;
import technology.grameen.gphc.app.healthapp.repositories.ChiefComplaintRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiefComplaintServiceImpl implements ChiefComplaintService{

    @Autowired
    private ChiefComplaintRepository chiefComplaintRepository;

    @Override
    @Transactional
    public void add(ChiefComplaint chiefComplaint) throws CustomException {

        Optional<ChiefComplaint> chiefComplaintOp = chiefComplaintRepository
                .findByTitleIgnoreCase(chiefComplaint.getTitle());

        if(chiefComplaint.getId() != null && chiefComplaintOp.isPresent()){
            if(!chiefComplaint.getId().equals(chiefComplaintOp.get().getId())){
                throw new CustomException("Chief Complaint already exist");
            }
        }

        if(chiefComplaint.getId() == null && chiefComplaintOp.isPresent()){
            throw new CustomException("Chief Complaint already exist");
        }

        if(chiefComplaint.getId()==null){
            chiefComplaint.setId(UUID.randomUUID());
        }
        chiefComplaintRepository.save(chiefComplaint);
    }

    @Override
    public List<ChiefComplaint> getAll() {
        return chiefComplaintRepository.findAll();
    }

    @Override
    public Optional<?> getDetail(String id) {
        return chiefComplaintRepository.findById(UUID.fromString(id));
    }
}
