package ru.boshchenko.rtz_app.utils.mapper;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

import java.util.Collection;


@Named("OrganizationMapperUtil")
@Component
public class OrganizationMapperUtil {

    private final UserService userService;
/** ленивая загрузка, чтобы не попадать в цикл */
    @Autowired
    public OrganizationMapperUtil(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Named("getUsersName")
    public Collection<String> getUsersName(Collection<User> users){
        return users.stream().map(User::getUsername).toList();
    }

    @Named("getUsers")
    public Collection<User> getUsers(Collection<String> usersName){
        return usersName.stream().map(userService::findByUsername).toList();
    }
}
