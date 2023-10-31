package ru.nikituz.axiomatictesttask.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoContract;
import ru.nikituz.axiomatictesttask.entities.Contract;
import ru.nikituz.axiomatictesttask.repositories.ContractRepository;
import ru.nikituz.axiomatictesttask.services.ContractService;
import ru.nikituz.axiomatictesttask.utils.mappers.ContractMapUtil;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Override
    @Transactional
    public List<DtoContract> getAll() {
        return contractRepository.findAll().stream()
                .map(ContractMapUtil::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    @Transactional
    public void sign(long id) {
        Contract contract = contractRepository.find(id);
        contract.setSignatureStatus(true);
        contract.setSignatureDate(new Date(System.currentTimeMillis()));
        contractRepository.update(contract);
    }
}
