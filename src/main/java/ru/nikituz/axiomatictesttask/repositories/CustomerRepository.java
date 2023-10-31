package ru.nikituz.axiomatictesttask.repositories;

import ru.nikituz.axiomatictesttask.entities.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer find(long id);
    void save(Customer customer);

    void update(Customer updatedCustomer);

    void delete(long id);

    List<Customer> findAll();

    List<Customer> findByFio(String fio);
    List<Customer> findByPassport(String passport);
    List<Customer> findByPhone(String phone);
}
