package ru.boshchenko.rtz_app.dto;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class OrganizationDto {

    private Long id;

    private String name;

    private String legalAddress;

    private Long ogrn;

    private Long inn;

    private Long kpp;

    private Long BICBank;

    private String bankNames;

    private Long paymentAccount;

    private Collection<String> usersName;

}