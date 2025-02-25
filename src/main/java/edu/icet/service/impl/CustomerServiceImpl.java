package edu.icet.service.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository  customerRepository;

    final ModelMapper mapper;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public List<Customer> getAll() {
        ArrayList<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> all = customerRepository.findAll();

        all.forEach(customerEntity ->
                customerList.add(mapper.map(customerEntity, Customer.class)));

        return customerList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(mapper.map(customer, CustomerEntity.class ));
    }

    @Override
    public Customer searchById(Integer id) {
        return mapper.map(customerRepository.findById(id), Customer.class);

    }

    @Override
    public List<Customer> searchByName(String name) {
        List<CustomerEntity> byName = customerRepository.findByName(name);
        List<Customer> customerList = new ArrayList<>();

        byName.forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));
        });

        return customerList;
    }

    @Override
    public List<Customer> searchByAddress(String address) {
        List<CustomerEntity> byAddress = customerRepository.findByAddress(address);
        List<Customer> customerList = new ArrayList<>();

        byAddress.forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));
        });


        return customerList;
    }

    @Override
    public List<Customer> searchBySalary(Double salary) {
       List<CustomerEntity> bySalary =customerRepository.findBySalary(salary);
       List<Customer> list=new ArrayList<>();

       bySalary.forEach(customerEntity ->
               list.add(mapper.map(customerEntity, Customer.class))
               );
       return list;
    }
}
