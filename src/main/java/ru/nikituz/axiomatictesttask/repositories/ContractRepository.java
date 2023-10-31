package ru.nikituz.axiomatictesttask.repositories;

import ru.nikituz.axiomatictesttask.entities.Contract;

import java.util.List;

public interface ContractRepository {

    List<Contract> findAll();

    void save(Contract contract);

    Contract find(long id);

    void update(Contract updatedContract);
}
