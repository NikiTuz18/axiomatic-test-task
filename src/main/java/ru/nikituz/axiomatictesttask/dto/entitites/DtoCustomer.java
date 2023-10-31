package ru.nikituz.axiomatictesttask.dto.entitites;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static ru.nikituz.axiomatictesttask.utils.validation.ValidationMessageUtil.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DtoCustomer {

    private long id;

    @Pattern(regexp = FIO_REGEXP, message = FIO_ERROR_MESSAGE)
    private String fio;

    @Pattern(regexp = PASSPORT_REGEXP, message = PASSPORT_ERROR_MESSAGE)
    private String passport;

    private boolean maritalStatus;

    @NotBlank(message = ADDRESS_ERROR_MESSAGE)
    private String address;

    @Pattern(regexp = PHONE_REGEXP, message = PHONE_ERROR_MESSAGE)
    private String phone;

    @NotBlank(message = EMPLOYMENT_ORGANIZATION_ERROR_MESSAGE)
    private String organization;

    @NotBlank(message = EMPLOYMENT_POSITION_ERROR_MESSAGE)
    private String position;

    @NotNull(message = EMPLOYMENT_PERIOD_NOT_NULL_ERROR_MESSAGE)
    @Min(value = 0, message = EMPLOYMENT_PERIOD_MIN_ERROR_MESSAGE)
    @Max(value = 100, message = EMPLOYMENT_PERIOD_MAX_ERROR_MESSAGE)
    private Integer period;

    @NotNull(message = CREDIT_AMOUNT_NOT_NULL_ERROR_MESSAGE)
    @DecimalMin(value = CREDIT_AMOUNT_MIN_VALUE, message = CREDIT_AMOUNT_MIN_VALUE_ERROR_MESSAGE)
    @Digits(integer=7, fraction=2, message = CREDIT_AMOUNT_RANGE_ERROR_MESSAGE)
    private BigDecimal creditAmount;

}
