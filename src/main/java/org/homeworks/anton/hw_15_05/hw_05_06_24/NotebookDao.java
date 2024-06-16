package org.homeworks.anton.hw_15_05.hw_05_06_24;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class NotebookDao  {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");


    public void ad(Notebook notebook)  {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(notebook);
        transaction.commit();
    }


    public Notebook findById(int id)  {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Notebook notebook = em.find(Notebook.class, id);
        System.out.println(notebook);
        transaction.commit();
        em.close();
        return notebook;
    }
}
