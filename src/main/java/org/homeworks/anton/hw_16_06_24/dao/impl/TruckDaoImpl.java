package org.homeworks.anton.hw_16_06_24.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.homeworks.anton.hw_15_05.hw_05_06_24.Notebook;
import org.homeworks.anton.hw_16_06_24.dao.TruckDao;
import org.homeworks.anton.hw_16_06_24.domain.Truck;

import java.sql.SQLException;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class TruckDaoImpl implements TruckDao {

    public static final EntityManagerFactory FACTORY =
            createEntityManagerFactory("antonio");
    @Override
    public List<Truck> showByDriver(String name) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        List<Truck> trucks = em.createQuery(
                        "SELECT t FROM Truck t JOIN Driver  d WHERE d.name LIKE :name",
                        Truck.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        em.close();
        return trucks;
    }

    @Override
    public void add(Truck truck) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(truck);
        transaction.commit();
    }

    @Override
    public void update(Truck truck) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(truck);
        transaction.commit();
        em.close();
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Truck t WHERE t.id =: t_id");
        query.setParameter("t_id", id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }


    @Override
    public void find(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Truck truck = em.find(Truck.class, id);
        System.out.println(truck);
        transaction.commit();
        em.close();
    }
}
