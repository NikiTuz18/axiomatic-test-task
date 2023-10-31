package ru.nikituz.axiomatictesttask.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.dto.search.CustomerSearch;
import ru.nikituz.axiomatictesttask.entities.Customer;
import ru.nikituz.axiomatictesttask.repositories.CustomerRepository;
import ru.nikituz.axiomatictesttask.search.CustomerSearchResolver;
import ru.nikituz.axiomatictesttask.services.CustomerService;
import ru.nikituz.axiomatictesttask.utils.mappers.CustomerMapUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final Map<String, CustomerSearchResolver> customerResolvers;

    @Override
    @Transactional
    public List<DtoCustomer> getAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapUtil::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoCustomer getById(long id) {
        return CustomerMapUtil.entityToDto(customerRepository.find(id));
    }

    @Override
    @Transactional
    public void updateById(long id, DtoCustomer updatedDtoCustomer) {
        Customer updatedCustomer = CustomerMapUtil.dtoToEntity(updatedDtoCustomer);
        updatedCustomer.setId(id);
        customerRepository.update(updatedCustomer);
    }

    @Override
    @Transactional
    public void deletedById(long id) {
        customerRepository.delete(id);
    }

    @Override
    @Transactional
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public List<DtoCustomer> search(CustomerSearch customerSearch) {
        return Optional.ofNullable(customerResolvers.get(customerSearch.getSearchType().toString()))
                .map(searchResolver -> searchResolver.resolve(customerSearch))
                .orElseThrow(() -> new RuntimeException("Поиск по данному параметру невозможен"));
    }
}
