package technology.grameen.gphc.app.services.prescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.prescription.Advice;
import technology.grameen.gphc.app.healthapp.repositories.AdviceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdviceServiceImpl implements AdviceService{

    @Autowired
    private AdviceRepository adviceRepository;

    @Override
    @Transactional
    public void add(Advice advice) {
        adviceRepository.save(advice);
    }

    @Override
    public List<Advice> getAll() {
        return adviceRepository.findAll();
    }

    @Override
    public Page<?> getAll(Pageable pageable) {
        return adviceRepository.findAll(pageable);
    }

    @Override
    public Optional<?> getById(String id) {
        return adviceRepository.findById(UUID.fromString(id));
    }
}
