package org.homeworks.anton.hw_15_05.hw_05_06_24;


import jakarta.persistence.*;

public class NotebookDao  {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("anton");


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
