package ru.nikituz.axiomatictesttask.dto.entitites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DtoContract {

    private long id;

    private String customerFio;

    private boolean signatureStatus;

    private Date signatureDate;
}
