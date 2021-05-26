package com.alevel;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CustomerDao customerDao = new CustomerDao(entityManager);

        System.out.println(customerDao.customersWithOrders());
    }
}
