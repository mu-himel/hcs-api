package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.TestDocument;

import java.util.UUID;

@Repository
public interface TestDocumentRepository extends JpaRepository<TestDocument, UUID> {

    @Query(value = "SELECT td FROM TestDocument td " +
            "JOIN FETCH td.profile p " +
            "WHERE p.id=:profileId",
    countQuery = "SELECT COUNT(td) FROM TestDocument td " +
            "JOIN td.profile p " +
            "WHERE p.id=:profileId")
    Page<TextDocumentInfo> findAllByProfileId(@Param("profileId") UUID profileId, Pageable pageable);

    interface Profile{
        UUID getId();
    }

    interface TextDocumentInfo{
        UUID getId();
        String getTitle();
        String getFile();
        String getNote();
        Profile getProfile();
    }

}
