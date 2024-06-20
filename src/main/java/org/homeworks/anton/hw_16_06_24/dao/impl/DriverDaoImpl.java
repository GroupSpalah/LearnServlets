package org.homeworks.anton.hw_16_06_24.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.homeworks.anton.hw_16_06_24.dao.CrudDao;
import org.homeworks.anton.hw_16_06_24.domain.Driver;
import org.homeworks.anton.hw_16_06_24.domain.Truck;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class DriverDaoImpl implements CrudDao<Driver> {
    public static final EntityManagerFactory FACTORY =
            createEntityManagerFactory("antonio");
    @Override
    public void add(Driver driver) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(driver);
        transaction.commit();
    }

    @Override
    public void update(Driver driver) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(driver);
        transaction.commit();
        em.close();
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Driver d WHERE d.id =: d_id");
        query.setParameter("d_id", id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }



    @Override
    public void find(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
       Driver driver = em.find(Driver.class, id);
        System.out.println(driver);
        transaction.commit();
        em.close();
    }
}
