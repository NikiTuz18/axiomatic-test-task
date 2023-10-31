package ru.nikituz.axiomatictesttask.utils.mappers;

import lombok.experimental.UtilityClass;
import ru.nikituz.axiomatictesttask.dto.entitites.DtoCustomer;
import ru.nikituz.axiomatictesttask.entities.Customer;
import ru.nikituz.axiomatictesttask.entities.Employment;

@UtilityClass
public class CustomerMapUtil {

    public static Customer dtoToEntity(DtoCustomer dtoCustomer){
        Employment employment = Employment.builder()
                .organization(dtoCustomer.getOrganization())
                .position(dtoCustomer.getPosition())
                .period(dtoCustomer.getPeriod())
                .build();
        return Customer.builder()
                .fio(dtoCustomer.getFio())
                .passport(dtoCustomer.getPassport())
                .maritalStatus(dtoCustomer.isMaritalStatus())
                .address(dtoCustomer.getAddress())
                .phone(dtoCustomer.getPhone())
                .employment(employment)
                .creditAmount(dtoCustomer.getCreditAmount())
                .build();
    }

    public static DtoCustomer entityToDto(Customer customer){
        return DtoCustomer.builder()
                .id(customer.getId())
                .fio(customer.getFio())
                .passport(customer.getPassport())
                .maritalStatus(customer.isMaritalStatus())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .organization(customer.getEmployment().getOrganization())
                .position(customer.getEmployment().getPosition())
                .period(customer.getEmployment().getPeriod())
                .creditAmount(customer.getCreditAmount())
                .build();
    }
}
