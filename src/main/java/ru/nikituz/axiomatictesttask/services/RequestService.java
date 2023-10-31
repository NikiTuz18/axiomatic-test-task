package ru.nikituz.axiomatictesttask.services;

import org.springframework.validation.BindingResult;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoRequest;

import java.util.List;

public interface RequestService {

    List<DtoRequest> getAll();

    DtoRequest create(DtoCustomer dtoCustomer);

    String responseFromRequest(DtoCustomer dtoCustomer, BindingResult bindingResult);

}
