package org.homeworks.anton.hw_16_06_24.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.homeworks.anton.hw_16_06_24.dao.TruckDao;
import org.homeworks.anton.hw_16_06_24.domain.Truck;

import java.sql.SQLException;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class TruckDaoImpl implements TruckDao {

    public static final EntityManagerFactory FACTORY =
            createEntityManagerFactory("anton");

    @Override
    public List<Truck> showByDriver(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        List<Truck> trucks = em.createQuery("SELECT t FROM Truck t WHERE t.driver.id = :driverId ", Truck.class)
                .setParameter("driverId", id)
                .getResultList();
        em.close();
        return trucks;
    }

    @Override
    public void add(Truck truck) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(truck);
        transaction.commit();
    }

    @Override
    public void update(Truck truck) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(truck);
        transaction.commit();
    }

    @Override
    public void deleteById(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Truck truck = em.find(Truck.class, id);
        em.remove(truck);
        transaction.commit();
    }


    @Override
    public Truck find(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Truck truck = em.find(Truck.class, id);
        transaction.commit();
        return truck;
    }
}
