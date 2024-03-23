package com.hibjunit;

import com.hibjunit.entities.PatientContacts;
import com.hibjunit.entities.PatientDetails;
import com.hibjunit.entities.PatientVisitHistory;
import com.hibjunit.utilities.AppUtils;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.hibjunit")
public class AppConfig {
    @Bean
    public HibernateTemplate setHibernateTemplate(){
        HibernateTemplate ht = new HibernateTemplate(this.setSessionFactory());
        return ht;
    }
    @Bean
    public SessionFactory setSessionFactory(){
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setAnnotatedClasses(PatientDetails.class, PatientContacts.class, PatientVisitHistory.class);
        sf.setHibernateProperties(AppUtils.configureHibernateProperties());
        sf.setDataSource(AppUtils.configureDatasource());
        try {
            sf.afterPropertiesSet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sf.getObject();
    }
    @Bean
    public HibernateTransactionManager setTransaction(){
        return new HibernateTransactionManager(this.setSessionFactory());
    }
}
