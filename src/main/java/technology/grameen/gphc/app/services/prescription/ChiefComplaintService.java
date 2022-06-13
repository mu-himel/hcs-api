package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;

import java.util.List;
import java.util.Optional;

public interface ChiefComplaintService {

    void add(ChiefComplaint chiefComplaint) throws CustomException;

    List<ChiefComplaint> getAll();

    Optional<?> getDetail(String id);
}
