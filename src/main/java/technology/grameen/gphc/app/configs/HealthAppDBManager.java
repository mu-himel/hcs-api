package technology.grameen.gphc.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"technology.grameen.gphc.app.healthapp.repositories"})
public class HealthAppDBManager {

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "healthDataSource")
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(env.getProperty("spring.healthapp.datasource.url"));
        ds.setUsername(env.getProperty("spring.healthapp.datasource.username"));
        ds.setPassword(env.getProperty("spring.healthapp.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.healthapp.datasource.driver-class-name"));
        return ds;
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("healthDataSource") DataSource dataSource){

        Map<String,String> properties = new HashMap<>();
        properties.put("hibernate.dialect",env.getProperty("spring.jpa.database-platform"));
        properties.put("hibernate.hbm2ddl.auto","update");
        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("technology.grameen.gphc.app.healthapp.entity")
                .persistenceUnit("configuration.EmailConfiguration")
                .persistenceUnit("configuration.PaymentConfiguration")
                .persistenceUnit("configuration.PaymentMethod")
                .persistenceUnit("configuration.ReportConfiguration")
                .persistenceUnit("configuration.SmsConfiguration")
                .persistenceUnit("configuration.SystemConfiguration")
                .persistenceUnit("GeoCountry")
                .persistenceUnit("GeoCity")
                .persistenceUnit("GeoState")
                .persistenceUnit("Site")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory")EntityManagerFactory entityManagerFactory
            ){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
