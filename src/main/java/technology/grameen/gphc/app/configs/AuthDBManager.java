package technology.grameen.gphc.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "authEntityManagerFactory",
        transactionManagerRef = "authTransactionManager",
        basePackages = {"technology.grameen.gphc.app.auth.repositories"})
public class AuthDBManager {

    @Autowired
    private Environment env;

    @Bean(name = "authDataSource")
    @ConfigurationProperties(prefix = "spring.auth.datasource")
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(env.getProperty("url"));
        ds.setUsername(env.getProperty("username"));
        ds.setPassword(env.getProperty("password"));
        ds.setDriverClassName(env.getProperty("spring.auth.datasource.driver-class-name"));
        return ds;
    }

    @Bean(name = "authEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("authDataSource") DataSource dataSource
    ){
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect",env.getProperty("spring.jpa.database-platform"));
        properties.put("hibernate.hbm2ddl.auto","update");
        return builder.dataSource(dataSource).properties(properties)
                .packages("technology.grameen.gphc.app.auth.entity")
                .persistenceUnit("User")
                .persistenceUnit("Role")
                .build();
    }

    @Bean(name = "authTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("authEntityManagerFactory")EntityManagerFactory entityManagerFactory
            ){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
