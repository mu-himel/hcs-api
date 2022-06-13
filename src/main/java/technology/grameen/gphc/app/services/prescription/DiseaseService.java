package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.exceptions.CustomException;
import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;
import technology.grameen.gphc.app.healthapp.entity.prescription.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseService {

    void add(Disease disease) throws CustomException;

    List<Disease> getAll();

    Optional<?> getById(String id);
}
