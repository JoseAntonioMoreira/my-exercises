package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {
    public static void main(String[] args) {
        // Use the test persistence unit to configure a new
        // entity manager factory and start up JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        // Open a new database connection by getting a new
        // entity manager from the entity manager factory
        EntityManager em = emf.createEntityManager();


        Details details = new Details();
        details.setName("Cristiano Penaldo");
        details.setAge(39);
        Cadet cadet = new Cadet();
        cadet.setDetails(details);

        em.getTransaction().begin();
        em.persist(cadet);
        em.getTransaction().commit();

        // Close the database connection
        em.close();

        FetchDatabase fetchDatabase = new FetchDatabase(emf.createEntityManager());
        System.out.println(fetchDatabase.getCadetbyID(1).getDetails().getName());

        // Shutdown JPA
        emf.close();

    }
}
