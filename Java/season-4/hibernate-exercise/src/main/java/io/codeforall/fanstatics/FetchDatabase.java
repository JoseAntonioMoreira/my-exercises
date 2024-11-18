package io.codeforall.fanstatics;

import javax.persistence.EntityManager;

public class FetchDatabase {
    EntityManager entityManager;

    public FetchDatabase(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Cadet getCadetbyID(Integer id) {
        return entityManager.find(Cadet.class, id);
    }
}

