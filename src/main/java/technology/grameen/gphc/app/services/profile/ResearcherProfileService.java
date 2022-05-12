package technology.grameen.gphc.app.services.profile;

import technology.grameen.gphc.app.healthapp.entity.profile.ResearcherProfile;

import java.util.Optional;
import java.util.UUID;

public interface ResearcherProfileService {

    ResearcherProfile addResearcherProfile(ResearcherProfile researcherProfile);

    Optional<?> getDetailByProfileId(UUID id);
}
