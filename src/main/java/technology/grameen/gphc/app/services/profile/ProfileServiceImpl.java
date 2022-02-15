package technology.grameen.gphc.app.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.profile.Profile;
import technology.grameen.gphc.app.healthapp.repositories.ProfileRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    @Transactional
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Boolean register(Profile profile) {
        Profile profileCreated =  addProfile(profile);
        return profileCreated !=null && profileCreated.getId() != null ? true : false;
    }

    @Override
    @Transactional
    public void updateProfile(String id, Profile profile) {
        Optional<Profile> profileOp = profileRepository.findById(UUID.fromString(id));

        if(profileOp.isPresent()){
            profileRepository.save(profile);
        }
    }
}
