package com.javarush.domain.petrenko.dao;

import com.javarush.domain.petrenko.entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CityDAO {
    private final SessionFactory sessionFactory;

    public CityDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<City> getItem(int offset, int count){
        Query<City> query = sessionFactory.getCurrentSession().createQuery("select s from City s", City.class);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.list();
    }

    public int getTotalCount(){
        Query<Long> query = sessionFactory.getCurrentSession().createQuery("select count(s) from City s", Long.class);
        return Math.toIntExact(query.uniqueResult());
    }
}
