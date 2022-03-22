package technology.grameen.gphc.app.services.criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.healthapp.entity.location.GeoCity;
import technology.grameen.gphc.app.healthapp.entity.location.GeoCountry;
import technology.grameen.gphc.app.healthapp.entity.location.GeoState;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.entity.site.Site;
import technology.grameen.gphc.app.healthapp.repositories.ProfileRepository;
import technology.grameen.gphc.app.response.CustomProfile;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProfileCriteriaImpl  implements ProfileCriteriaRepository{

    @Autowired
    EntityManager entityManager;


    @Override
    public Page<?> findByWhere(Pageable pageable, String firstName, String lastName,
                               String email,String contactNumber, String siteId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomProfile> cq = cb.createQuery(CustomProfile.class);
        Metamodel m = entityManager.getMetamodel();
        Root<Profile> root = cq.from(Profile.class);
        Join<Profile, Site> site = root.join("site", JoinType.LEFT);
        Join<Site, GeoCountry> country = site.join("country");
        Join<Site, GeoCity> city = site.join("city");
        Join<Site, GeoState> state = site.join("state");
        List<Predicate> predicates = new ArrayList<>();
        if(!firstName.isEmpty()) {
            Predicate pFirstName = cb.like(root.get("firstName"), firstName+"%");
            predicates.add(pFirstName);
        }
        if(!lastName.isEmpty()) {
            Predicate pLastName = cb.like(root.get("lastName"), lastName+"%");
            predicates.add(pLastName);
        }
        if(!email.isEmpty()) {
            Predicate pEmail = cb.equal(root.get("email"), email);
            predicates.add(pEmail);
        }
        if(!contactNumber.isEmpty()) {
            Predicate pContactNumber = cb.equal(root.get("contactNumber"), contactNumber);
            predicates.add(pContactNumber);
        }

        if(!siteId.isEmpty()) {
            Predicate pSite = cb.equal(site.get("id"), UUID.fromString(siteId));
            predicates.add(pSite);
        }
        cq.select(cb.construct(CustomProfile.class,root.get("id"),root.get("firstName"),root.get("lastName"),
                site.get("id"),site.get("title")));
        cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        List<CustomProfile> result = entityManager.createQuery(cq)
                .setFirstResult((int)pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();


        // count
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Profile> countRoot = countQuery.from(Profile.class);
        Join<Profile, Site> cSite = countRoot.join("site", JoinType.LEFT);
        countQuery.select(cb.count(countRoot.get("id"))).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        Long count = entityManager.createQuery(countQuery).getSingleResult();

        Page<CustomProfile> page = new PageImpl<>(result,pageable,count);
        return page;
    }
}
