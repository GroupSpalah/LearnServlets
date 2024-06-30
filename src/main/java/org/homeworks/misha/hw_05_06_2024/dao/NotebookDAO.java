package org.homeworks.misha.hw_05_06_2024.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.homeworks.misha.hw_05_06_2024.domain.NotebookM;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class NotebookDAO {
    public static final EntityManagerFactory FACTORY =
            createEntityManagerFactory("misha");

    public void add(NotebookM notebook)  {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(notebook);
        transaction.commit();
    }

    public NotebookM findById(int id)  {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        NotebookM notebook = em.find(NotebookM.class, id);
        System.out.println(notebook);
        transaction.commit();
        em.close();
        return notebook;
    }
}
