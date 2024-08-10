package org.homeworks.misha.hw_20_06_2024.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.homeworks.misha.hw_20_06_2024.dao.TruckDAO;
import org.homeworks.misha.hw_20_06_2024.domain.DriverM;
import org.homeworks.misha.hw_20_06_2024.domain.TruckM;

import java.sql.SQLException;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class TruckDAOImpl implements TruckDAO {

    public static final EntityManagerFactory FACTORY =
            createEntityManagerFactory("misha");

    @Override
    public void add(TruckM truck) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(truck);
        transaction.commit();
    }

    @Override
    public void update(TruckM truck) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(truck);
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
    public TruckM findById(int id) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TruckM truck = em.find(TruckM.class, id);
        System.out.println(truck);
        transaction.commit();
        return truck;
    }

    @Override
    public List<TruckM> findByDriverId(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        List<TruckM> trucks = em.createQuery("SELECT t FROM TruckM t WHERE t.driver.id = :driverId",
                        TruckM.class)
                .setParameter("driverId", id)
                .getResultList();
        em.close();
        return trucks;
    }
}
