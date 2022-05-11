package technology.grameen.gphc.app.healthapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.services.criteria.ProfileCriteriaRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    @Query(value = "SELECT pu FROM ProfileUser pu " +
            "JOIN FETCH pu.profile p " +
            "LEFT JOIN FETCH p.site s " +
            "WHERE p.id = :id")
    Optional<ProfileUser> findProfileById(@Param("id") UUID id);

    @Query(value = "SELECT pu FROM ProfileUser pu " +
            "JOIN FETCH pu.profile p " +
            "LEFT JOIN FETCH p.site s " +
            "WHERE pu.userId = :id")
    Optional<ProfileUser> findProfileByUserId(@Param("id") String id);

    Optional<?> findByEmail(String email);

    Optional<ProfilePageInfo> findByPid(String id);

    @Modifying
    @Query(value = "UPDATE Profile p SET p.roleId = :role WHERE p.id=:id")
    void updateRole(@Param("id") UUID id,@Param("role") String role);

    interface ProfileUser{
        ProfilePageInfo getProfile();
        String getUserId();
        String getUsername();
        UUID getId();
    }

    interface ProfilePageInfo{
        String getBloodGroup();
        String getContactNumber();
        String getContactNumber2();
        String getEmail();
        String getProfileImage();
        String getFirstName();
        String getLastName();
        void setFirstName(String firstName);
        void setLastName(String lastName);
        String getGuardianName();
        String getIdentityType();
        String getIdentityValue();
        String getReligion();
        String getMaritalStatus();
        SiteInfo getSite();
        UUID getId();
        String getPid();
        String getRoleId();
    }

    interface SiteInfo{
        UUID getId();
        String getTitle();
    }

    @Query(value = "SELECT p FROM Profile p " +
            "LEFT JOIN FETCH p.site s ",
    countQuery = "SELECT count(p) FROM Profile p JOIN p.site s ")
    Page<ProfilePageInfo> findAllProfiles(Pageable pageable);

    @Query(value = "SELECT p FROM Profile p " +
            "LEFT JOIN FETCH p.site s " +
            "where  lower(p.firstName) LIKE '%' || lower(:firstName) || '%'",
    countQuery = "SELECT count(p) FROM Profile p JOIN p.site s "+
            "where lower(p.firstName) LIKE '%' || lower(:firstName) || '%'")
    Page<ProfilePageInfo> findAllProfiles(Pageable pageable,
                                          @Param("firstName") String firstName);

    @Query(value = "SELECT p FROM Profile p " +
            "LEFT JOIN FETCH p.site s " +
            "where  lower(p.firstName) LIKE '%' || lower(:firstName) || '%' " +
            "OR lower(p.lastName) LIKE '%' || lower(:lastName) || '%'",
            countQuery = "SELECT count(p) FROM Profile p JOIN p.site s "+
                    "where lower(p.firstName) LIKE '%' || lower(:firstName) || '%' " +
                    "OR lower(p.lastName) LIKE '%' || lower(:lastName) || '%'")
    Page<ProfilePageInfo> findAllProfiles(Pageable pageable,
                                          @Param("firstName") String firstName,
                                          @Param("lastName") String lastName);
}
