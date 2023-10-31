package ru.nikituz.axiomatictesttask.search.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.dto.search.CustomerSearch;
import ru.nikituz.axiomatictesttask.repositories.CustomerRepository;
import ru.nikituz.axiomatictesttask.search.CustomerSearchResolver;
import ru.nikituz.axiomatictesttask.utils.mappers.CustomerMapUtil;

import java.util.List;
import java.util.stream.Collectors;

@Component("PHONE")
@RequiredArgsConstructor
public class PhoneCustomerSearchResolver implements CustomerSearchResolver {

    private final CustomerRepository customerRepository;

    @Override
    public List<DtoCustomer> resolve(CustomerSearch customerSearch) {
        return this.customerRepository.findByPhone(customerSearch.getSearchQuery()).stream()
                .map(CustomerMapUtil::entityToDto)
                .collect(Collectors.toList());
    }
}
