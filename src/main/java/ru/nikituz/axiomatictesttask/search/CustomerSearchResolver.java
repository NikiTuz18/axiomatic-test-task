package ru.nikituz.axiomatictesttask.search;

import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.dto.search.CustomerSearch;

import java.util.List;

@FunctionalInterface
public interface CustomerSearchResolver {

    List<DtoCustomer> resolve(CustomerSearch customerSearch);
}
