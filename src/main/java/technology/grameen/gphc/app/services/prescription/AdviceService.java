package technology.grameen.gphc.app.services.prescription;

import technology.grameen.gphc.app.healthapp.entity.prescription.Advice;

import java.util.List;

public interface AdviceService {
    void add(Advice advice);
    List<Advice> getAll();
}
