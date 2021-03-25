package repository.impl;

import entity.Customer;
import org.springframework.stereotype.Repository;
import repository.CustomerRepository;
import storage.Storage;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer add(Customer customer) {
        customer.setId(Storage.generateCustomerId());
        Storage.getCustomers().add(customer);
        return customer;
    }

    @Override
    public Customer get(Long id) {
        return Storage.getCustomers().stream()
                .filter(auction -> auction.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Cant find customer with id " + id));
    }

    @Override
    public Customer update(Customer customer) {
        Customer customerFromStorage = get(customer.getId());
        customerFromStorage.setLogin(customer.getLogin());
        return customerFromStorage;
    }
}
