package technology.grameen.gphc.app.services.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import technology.grameen.gphc.app.healthapp.entity.profile.TestDocument;

import java.util.Optional;

public interface TestDocumentService {

    TestDocument addTestDocument(TestDocument testDocument);

    Optional<?> getTestDocumentById(String id);

    Page<?> getAll(Pageable pageable);
}
