package com.alevel;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CustomerDao customerDao = new CustomerDao(entityManager);
        List<CustomerEntity> customers = customerDao.getAll();
        System.out.println(customers);

/*        CustomerEntity customer = customerDao.getById(1);
        System.out.println(customer);*/

/*        OrderEntity order = new OrderEntity();
        CustomerEntity newCustomer = new CustomerEntity("test1", "Mexico1", "Mexico City1");
        newCustomer.setOrders(Collections.singletonList(order));
        order.setCustomer(newCustomer);
        CustomerEntity createdCustomer = customerDao.add(newCustomer);
        System.out.println(createdCustomer);*/
    }
}
