package io.codeforall.funstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Car car = new Car();
        car.setMake("bmw");
        car.setModel("serie 1");

        Owner owner = new Owner();
        owner.setCar(car);
        owner.setName("otao");

        car.setOwner(owner);

        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.persist(owner);
        entityManager.getTransaction().commit();


        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();

        Owner gettedOwner = entityManager.find(Owner.class, 1);
        System.out.println(gettedOwner.getCar().getModel() + " " + gettedOwner.getCar().getMake() + " " + gettedOwner.getName());

        Car newCar = new Car();
        newCar.setMake("KIA");
        newCar.setModel("CEED");
        newCar.setOwner(gettedOwner);

        entityManager.getTransaction().begin();
        gettedOwner.setCar(newCar);
        entityManager.getTransaction().commit();

        gettedOwner = entityManager.find(Owner.class, 1);
        System.out.println(gettedOwner.getCar().getModel() + " " + gettedOwner.getCar().getMake() + " " + gettedOwner.getName());

        entityManager.close();

        entityManagerFactory.close();
    }
}
