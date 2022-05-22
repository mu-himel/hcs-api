package technology.grameen.gphc.app.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.profile.TestDocument;
import technology.grameen.gphc.app.healthapp.repositories.TestDocumentRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class TestDocumentServiceImpl implements TestDocumentService{

    @Autowired
    private TestDocumentRepository testDocumentRepository;

    @Override
    @Transactional
    public TestDocument addTestDocument(TestDocument testDocument) {
        return testDocumentRepository.save(testDocument);
    }

    @Override
    public Optional<?> getTestDocumentById(String id) {
        return testDocumentRepository.findById(UUID.fromString(id));
    }

    @Override
    public Page<?> getAll(String profileId, Pageable pageable) {
        return testDocumentRepository.findAllByProfileId(UUID.fromString(profileId), pageable);
    }

    @Override
    public Optional<?> getById(String id) {
        return testDocumentRepository.findTestDocumentById(UUID.fromString(id));
    }
}
