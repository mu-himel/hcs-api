package technology.grameen.gphc.app.services.criteria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProfileCriteriaRepository {

    Page<?> findByWhere(Pageable pageable, String firstName, String lastName,
                        String email, String contactNumber, String siteId);
}
