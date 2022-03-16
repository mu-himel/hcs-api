package technology.grameen.gphc.app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@PropertySource("classpath:application.properties")
public class UrlBuilder {

    @Autowired
    private Environment env;

    public  String getAdminAccessTokenUrl(){
        return env.getProperty("auth.domain")+env.getProperty("auth.realm.master")+
                env.getProperty("uri.token");
    }

    public String getRoleEndPoint(){
        String url = env.getProperty("auth.role.user");

        return url;
    }

    public String getRoleEndPoint(Optional<Integer> first, Optional<Integer> max){
        String url = env.getProperty("auth.domain")+env.getProperty("auth.admin.realm.app")+
                env.getProperty("uri.roles");
        if(first.isPresent() && max.isPresent()) {
            url += "?first=" + first.get() + "&max=" + max.get();
        }
        return url;
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public String getUserEndPoint() {
        String url = env.getProperty("auth.domain")+env.getProperty("auth.admin.realm.app")+
                env.getProperty("uri.users");

        return url;
    }

    public String getEhrEndpoint(){
        String url = env.getProperty("ehr")+env.getProperty("ehr.register");
        return url;
    }

    public String getFhirEndpoint(){
        String url = env.getProperty("fhir");
        return url;
    }

    public String getEhrCompositionEndpoint(){
        String url = env.getProperty("ehr")+env.getProperty("ehr.composition");
        return url;
    }


}
