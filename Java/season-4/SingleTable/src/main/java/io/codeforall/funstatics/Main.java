package io.codeforall.funstatics;

import io.codeforall.funstatics.Person.Cadet;
import io.codeforall.funstatics.Person.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Cadet cadet = new Cadet();

        cadet.setAge(20);
        cadet.setName("Jonny");

        Teacher teacher = new Teacher();
        teacher.setPatent("Master");
        teacher.setName("Otao");

        entityManager.getTransaction().begin();
        entityManager.persist(cadet);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
