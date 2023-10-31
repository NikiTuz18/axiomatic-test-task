package ru.nikituz.axiomatictesttask.utils.mappers;

import lombok.experimental.UtilityClass;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoContract;
import ru.nikituz.axiomatictesttask.entities.Contract;

@UtilityClass
public class ContractMapUtil {
    public static Contract dtoToEntity(DtoContract dtoContract){
        return Contract.builder()
                .signatureStatus(dtoContract.isSignatureStatus())
                .signatureDate(dtoContract.getSignatureDate())
                .build();
    }

    public static DtoContract entityToDto(Contract contract){
        return DtoContract.builder()
                .id(contract.getId())
                .customerFio(contract.getRequest().getCustomer().getFio())
                .signatureStatus(contract.isSignatureStatus())
                .signatureDate(contract.getSignatureDate())
                .build();
    }
}
