package technology.grameen.gphc.app.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import technology.grameen.gphc.app.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
