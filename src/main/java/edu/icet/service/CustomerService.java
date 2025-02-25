package edu.icet.service;


import edu.icet.dto.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAll();

    void deleteCustomer(Integer id);

    void updateCustomer(Customer customer);

    Customer searchById(Integer id);

    List<Customer> searchByName(String name);

    List<Customer> searchByAddress(String address);

    List<Customer> searchBySalary(Double salary);
}



