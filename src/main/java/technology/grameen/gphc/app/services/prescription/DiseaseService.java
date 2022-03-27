package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;
import technology.grameen.gphc.app.healthapp.entity.prescription.Disease;

import java.util.List;

public interface DiseaseService {

    void add(Disease disease);

    List<Disease> getAll();
}
