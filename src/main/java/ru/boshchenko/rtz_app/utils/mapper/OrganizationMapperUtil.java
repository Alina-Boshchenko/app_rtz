package ru.boshchenko.rtz_app.utils.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

import java.util.Collection;
import java.util.List;

@Named("OrganizationMapperUtil")
@Component
@RequiredArgsConstructor
public class OrganizationMapperUtil {

    private final UserService userService;

    @Named("getUsersName")
    public Collection<String> getUsersName(Collection<User> users){
        return users.stream().map(u -> u.getUserName()).toList();
    }

    @Named("getUsers")
    public Collection<User> getUsers(Collection<String> usersName){
        return usersName.stream().map(u -> userService.findByUserName(u)).toList();
    }
}
