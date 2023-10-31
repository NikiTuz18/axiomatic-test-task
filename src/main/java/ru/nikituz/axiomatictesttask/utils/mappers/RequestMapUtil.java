package ru.nikituz.axiomatictesttask.utils.mappers;

import lombok.experimental.UtilityClass;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoRequest;
import ru.nikituz.axiomatictesttask.entities.Request;

@UtilityClass
public class RequestMapUtil {
    public static Request dtoToEntity(DtoRequest dtoRequest){
        return Request.builder()
                .approvedAmount(dtoRequest.getApprovedAmount())
                .approvalStatus(dtoRequest.isApprovalStatus())
                .period(dtoRequest.getPeriod())
                .build();
    }

    public static DtoRequest entityToDto(Request request){
        return DtoRequest.builder()
                .customerFio(request.getCustomer().getFio())
                .approvedAmount(request.getApprovedAmount())
                .approvalStatus(request.isApprovalStatus())
                .period(request.getPeriod())
                .build();
    }
}
