package technology.grameen.gphc.app.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.auth.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<?> findByEmail(String email);
    Optional<?> findByUsername(String username);
}
