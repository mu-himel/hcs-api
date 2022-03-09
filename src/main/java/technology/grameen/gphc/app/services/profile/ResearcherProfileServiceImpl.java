package technology.grameen.gphc.app.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.profile.ResearcherProfile;
import technology.grameen.gphc.app.healthapp.repositories.ResearcherProfileRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class ResearcherProfileServiceImpl implements ResearcherProfileService{

    @Autowired
    private ResearcherProfileRepository researcherProfileRepository;

    @Override
    @Transactional
    public ResearcherProfile addResearcherProfile(ResearcherProfile researcherProfile) {
        return researcherProfileRepository.save(researcherProfile);
    }

    @Override
    public Optional<?> getDetailByProfieId(UUID id) {
        return researcherProfileRepository.findById(id);
    }
}
