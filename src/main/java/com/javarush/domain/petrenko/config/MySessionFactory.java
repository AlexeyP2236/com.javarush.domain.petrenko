package com.javarush.domain.petrenko.config;

import com.javarush.domain.petrenko.entity.City;
import com.javarush.domain.petrenko.entity.Country;
import com.javarush.domain.petrenko.entity.CountryLanguage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class MySessionFactory {
    private static MySessionFactory instance;
    private final SessionFactory sessionFactory;

    private MySessionFactory() {
//        Properties properties = new Properties();
//        try {
//            properties.load(ClassLoader.getSystemResourceAsStream("hibernate.properties"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        sessionFactory = new Configuration().
//                setProperties(properties).
                addAnnotatedClass(City.class).
                addAnnotatedClass(Country.class).
                addAnnotatedClass(CountryLanguage.class).
                buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) instance = new MySessionFactory();
        return instance.sessionFactory;
    }
}
