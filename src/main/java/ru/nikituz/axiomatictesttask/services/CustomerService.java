package ru.nikituz.axiomatictesttask.services;

import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.dto.search.CustomerSearch;
import ru.nikituz.axiomatictesttask.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<DtoCustomer> getAll();

    DtoCustomer getById(long id);

    void updateById(long id, DtoCustomer updatedDtoCustomer);

    void deletedById(long id);

    void create(Customer customer);

    List<DtoCustomer> search(CustomerSearch customerSearch);
}
