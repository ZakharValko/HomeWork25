package com.alevel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

    public static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.alevel.data.jpa.hibernate");
        return entityManagerFactory.createEntityManager();
    }
}
