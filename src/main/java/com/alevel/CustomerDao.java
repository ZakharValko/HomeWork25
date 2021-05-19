package com.alevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDao {

    private SessionFactory sessionFactory;

    public CustomerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CustomerEntity> getAll() { ;
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM CustomerEntity").list();
    }

    public CustomerEntity getById(Integer id) { ;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM CustomerEntity WHERE id = :customerId");
        query.setParameter("customerId", id);
        query.setCacheable(true);
        return (CustomerEntity) query.getSingleResult();
    }

    public CustomerEntity add(CustomerEntity newEntity) { ;
        Session session = sessionFactory.openSession();
        Integer id = (Integer) session.save(newEntity);
        session.close();
        return getById(id);
    }
}
