package ru.boshchenko.rtz_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
/** формат полей в апи-контрактах используется ни CamelCase, а snake_case,
 * автоматическая трансляции полей из кэмлкейс в снейккейс */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDto {

    private Long id;
    private String username;
    /** передаем только при получении данных из вне, т.е. при создании пользователя */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String phone;
    private Long inn;
    private Collection<String> organizationsName;



}