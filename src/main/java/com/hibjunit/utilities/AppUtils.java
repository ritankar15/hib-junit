package com.hibjunit.utilities;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AppUtils {
    public static DataSource configureDatasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/hibernate1");
        ds.setUsername("springstudent");
        ds.setPassword("springstudent");
        return ds;
    }
    public static Properties configureHibernateProperties(){
        Properties props = new Properties();
        props.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        props.put("hibernate.show_sql",true);
        props.put("hibernate.format_sql",true);
        props.put("hibernate.hbm2ddl.auto","update");
        return props;
    }
    public static Date standardisedDate(String dateandtime){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        Date date = null;
        try {
            date = formatter.parse(dateandtime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
