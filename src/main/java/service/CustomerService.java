package service;

import entity.Customer;

public interface CustomerService {
    Customer add(Customer customer);

    Customer get(Long id);

    Customer update(Customer customer);
}
