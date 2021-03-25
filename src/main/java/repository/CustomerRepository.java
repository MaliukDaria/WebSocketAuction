package repository;

import entity.Customer;

public interface CustomerRepository {
    Customer add(Customer customer);

    Customer get(Long id);

    Customer update(Customer customer);
}
