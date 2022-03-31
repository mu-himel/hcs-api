package technology.grameen.gphc.app.services.prescription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.prescription.Advice;

import java.util.List;
import java.util.Optional;

public interface AdviceService {
    void add(Advice advice);
    List<Advice> getAll();

    Page<?> getAll(Pageable pageable);

    Optional<?> getById(String id);
}
