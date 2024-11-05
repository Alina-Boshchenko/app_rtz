package ru.boshchenko.rtz_app.dto;

import lombok.*;


import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String phone;
    private Long inn;
    private Collection<String> organizationsName;




}