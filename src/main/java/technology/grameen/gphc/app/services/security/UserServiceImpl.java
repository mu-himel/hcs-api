package technology.grameen.gphc.app.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technology.grameen.gphc.app.auth.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<?> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<?> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<?> getUserRole(String userId) {
        return Optional.empty();
    }
}
