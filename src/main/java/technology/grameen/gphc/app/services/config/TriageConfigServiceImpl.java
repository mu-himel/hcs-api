package technology.grameen.gphc.app.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import technology.grameen.gphc.app.healthapp.entity.configuration.TriageConfiguration;
import technology.grameen.gphc.app.healthapp.repositories.TriageConfigRepository;

import java.util.*;
import java.util.stream.Stream;

@Service
public class TriageConfigServiceImpl implements TriageConfigService{

    @Autowired
    private TriageConfigRepository triageConfigRepository;

    @Override
    @Transactional
    public TriageConfiguration addConfig(TriageConfiguration triageConfiguration) {
        return triageConfigRepository.save(triageConfiguration);
    }

    @Override
    public Page<TriageConfiguration> getAll(Pageable pageable) {
        return triageConfigRepository.findAll(pageable);
    }

    @Override
    public Optional<TriageConfiguration> getConfig(UUID id) {
        return triageConfigRepository.findById(id);
    }

    @Override
    public Map<String, Object> getRef() {
        Map<String,Object> map = new HashMap<>();
        Stream<TriageConfiguration> triageConfigurationStream = triageConfigRepository.findAll().stream();
        triageConfigurationStream.forEach(triage->{
            Map<String,Object> tRef = new HashMap<>();
            tRef.put("lowerWarning",triage.getLowerWarning());
            tRef.put("upperWarning",triage.getLowerWarning());
            tRef.put("green",triage.getGreen());
            tRef.put("yellow",triage.getYellow());
            tRef.put("orange",triage.getOrange());
            tRef.put("red",triage.getRed());
            tRef.put("paramName",triage.getParamName());
            tRef.put("spec",triage.getSpec());
            tRef.put("dataType",triage.getDataType());
            map.put(getFieldKey(triage),tRef);
        });
        return map;
    }
    private String getFieldKey(TriageConfiguration triage){
        String[] alias = triage.getAlias().split("-");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<alias.length; i++){
            String s = alias[i];
            if(i==0){
                sb.append(s);
            }
            if(i>0){
                sb.append(String.valueOf(s.charAt(0)).toUpperCase(Locale.ROOT));
                sb.append(s.substring(1,s.length()));
            }
        }
        return sb.toString();
    }
}
