package ru.nikituz.axiomatictesttask.dto.entitites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DtoRequest {

    private String customerFio;

    private BigDecimal approvedAmount;

    private boolean approvalStatus;

    private int period;
}
