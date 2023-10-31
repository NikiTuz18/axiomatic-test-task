package ru.nikituz.axiomatictesttask.services;

import ru.nikituz.axiomatictesttask.dto.entitites.DtoContract;
import ru.nikituz.axiomatictesttask.entities.Contract;

import java.util.List;

public interface ContractService {

    List<DtoContract>getAll();

    void create(Contract contract);

    void sign(long id);
}
