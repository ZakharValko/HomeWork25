package com.alevel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerDao {

    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<CustomerEntity> getAll() {
        //return entityManager.createQuery("FROM CustomerEntity", CustomerEntity.class).getResultList();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> query = criteriaBuilder.createQuery(CustomerEntity.class);
        Root<CustomerEntity> from = query.from(CustomerEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.lessThan(from.get("id"), 3));
        predicates.add(criteriaBuilder.equal(from.get("city"), "Washington"));
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }

    public CustomerEntity getById(Integer id) {
        //Query query = entityManager.createQuery("FROM CustomerEntity WHERE id = :customerId");
        //query.setParameter("customerId", id);
        //query.setHint(QueryHints.CACHEABLE, true);
        //return (CustomerEntity) query.getSingleResult();
        return entityManager.find(CustomerEntity.class, id);
    }

    public CustomerEntity add(CustomerEntity newEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
/*        newEntity.getOrders()
                .forEach(order -> entityManager.persist(order));*/
        entityManager.persist(newEntity);
        transaction.commit();
        return getById(newEntity.getId());
    }
}
