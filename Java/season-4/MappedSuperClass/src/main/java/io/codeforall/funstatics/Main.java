package io.codeforall.funstatics;

import io.codeforall.funstatics.Persons.Cadet;
import io.codeforall.funstatics.Persons.Teacher;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        // Use the test persistence unit to configure a new
        // entity manager factory and start up JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        // Open a new database connection by getting a new
        // entity manager from the entity manager factory
        EntityManager em = emf.createEntityManager();

        Cadet cadet = new Cadet();
        cadet.setAge(10);
        cadet.setName("Jonny");

        Teacher teacher = new Teacher();
        teacher.setPatent("Master");
        teacher.setName("Oscar");

        em.getTransaction().begin();
        em.persist(cadet);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();

        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();
    }
}
