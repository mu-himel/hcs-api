package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.healthapp.entity.prescription.ChiefComplaint;

import java.util.List;

public interface ChiefComplaintService {

    void add(ChiefComplaint chiefComplaint);

    List<ChiefComplaint> getAll();
}
