package org.homeworks.anton.hw_16_06_24.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.homeworks.anton.hw_16_06_24.dao.CrudDao;
import org.homeworks.anton.hw_16_06_24.domain.Driver;



import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class DriverDaoImpl implements CrudDao<Driver> {
    public static final EntityManagerFactory FACTORY =
            createEntityManagerFactory("anton");
    @Override
    public void add(Driver driver) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(driver);
        transaction.commit();
    }

    @Override
    public void update(Driver driver) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(driver);
        transaction.commit();
    }

    @Override
    public void deleteById(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Driver driver = em.find(Driver.class, id);
        em.remove(driver);
        transaction.commit();
    }



    @Override
    public Driver find(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
       Driver driver = em.find(Driver.class, id);
        System.out.println(driver);
        transaction.commit();
        return driver;
    }
}
