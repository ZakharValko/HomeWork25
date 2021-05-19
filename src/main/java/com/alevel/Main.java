package com.alevel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao(HibernateUtils.getSessionFactory());
        List<CustomerEntity> customers = customerDao.getAll();
        System.out.println(customers);

        CustomerEntity customer = customerDao.getById(1);
        System.out.println(customer);

        CustomerEntity newCustomer = new CustomerEntity("Max", "Holland", "Amsterdam");
        CustomerEntity createdCustomer = customerDao.add(newCustomer);
        System.out.println(createdCustomer);
    }
}
