package technology.grameen.gphc.app.healthapp.repositories;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.TestDocument;

import java.time.LocalDateTime;
import java.util.Optional;
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

    @Query(value = "SELECT td FROM TestDocument td " +
            "JOIN FETCH td.profile p WHERE td.id=:id")
    Optional<TextDocumentInfo> findTestDocumentById(@Param("id") UUID profileId);

    interface Profile{
        UUID getId();
    }

    interface TextDocumentInfo{
        UUID getId();
        String getTitle();
        String getFile();
        String getNote();
        Profile getProfile();

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime getUpdatedAt();
    }

}
