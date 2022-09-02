package com.ronald.project01.service;

import com.ronald.project01.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomerById(Long id);
}
