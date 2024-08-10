package org.homeworks.misha.hw_20_06_2024.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.homeworks.misha.hw_20_06_2024.dao.CrudDAO;
import org.homeworks.misha.hw_20_06_2024.domain.DriverM;

import java.sql.SQLException;


import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class DriverDAOImpl implements CrudDAO<DriverM> {
    public static final EntityManagerFactory FACTORY =
            createEntityManagerFactory("misha");

    @Override
    public void add(DriverM driver) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(driver);
        transaction.commit();

    }

    @Override
    public void update(DriverM driver) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(driver);
        transaction.commit();

    }

    @Override
    public void deleteById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        DriverM driver = em.find(DriverM.class, id);
        em.remove(driver);
        transaction.commit();

    }

    @Override
    public DriverM findById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        DriverM driver = em.find(DriverM.class, id);
        System.out.println(driver);
        transaction.commit();
        return driver;
    }


}
