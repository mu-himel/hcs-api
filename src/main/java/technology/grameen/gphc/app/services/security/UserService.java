package technology.grameen.gphc.app.services.security;

import java.util.Optional;

public interface UserService {

    Optional<?> findUserByEmail(String email);
    Optional<?> findUserByUsername(String username);

    Optional<?> getUserRole(String userId);
}
