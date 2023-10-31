package ru.nikituz.axiomatictesttask.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoRequest;
import ru.nikituz.axiomatictesttask.entities.Contract;
import ru.nikituz.axiomatictesttask.entities.Customer;
import ru.nikituz.axiomatictesttask.entities.Request;
import ru.nikituz.axiomatictesttask.repositories.RequestRepository;
import ru.nikituz.axiomatictesttask.services.ContractService;
import ru.nikituz.axiomatictesttask.services.CustomerService;
import ru.nikituz.axiomatictesttask.services.RequestService;
import ru.nikituz.axiomatictesttask.utils.mappers.CustomerMapUtil;
import ru.nikituz.axiomatictesttask.utils.mappers.RequestMapUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    private final CustomerService customerService;
    private final ContractService contractService;

    @Override
    @Transactional
    public List<DtoRequest> getAll() {
        return requestRepository.findAll().stream()
                .map(RequestMapUtil::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DtoRequest create(final DtoCustomer dtoCustomer) {
        Customer customer = CustomerMapUtil.dtoToEntity(dtoCustomer);
        Request request = requestByCustomer(customer);
        customerService.create(customer);
        requestRepository.save(request);
        createContractByRequestIfItsApproved(request);
        return RequestMapUtil.entityToDto(request);
    }

    @Override
    @Transactional
    public String responseFromRequest(DtoCustomer dtoCustomer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "request-new";
        }
        DtoRequest createdRequest = create(dtoCustomer);
        if(createdRequest.isApprovalStatus()){
            return new StringBuilder("redirect:/requests/new/result?approvalStatus=true&period=")
                    .append(createdRequest.getPeriod())
                    .append("&approvedAmount=")
                    .append(createdRequest.getApprovedAmount())
                    .toString();
        } else {
            return "redirect:/requests/new/result?approvalStatus=false";
        }
    }

    private Request requestByCustomer(Customer customer){
        return Request.builder()
                .approvalStatus(new Random().nextBoolean())
                .period((new Random().nextInt(365-30) + 30))
                .approvedAmount(customer.getCreditAmount())
                .customer(customer)
                .build();
    }

    private void createContractByRequestIfItsApproved(final Request request){
        if(request.isApprovalStatus()){
            Contract contract = Contract.builder()
                    .signatureStatus(false)
                    .request(request)
                    .build();
            contractService.create(contract);
        }
    }
}
