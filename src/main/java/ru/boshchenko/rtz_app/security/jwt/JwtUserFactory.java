package ru.boshchenko.rtz_app.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.boshchenko.rtz_app.model.Role;
import ru.boshchenko.rtz_app.model.Status;
import ru.boshchenko.rtz_app.model.User;

import java.util.Collection;
import java.util.List;

/** реализация шаблона фабрика */

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser createJwtUser(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPatronymic(),
                user.getEmail(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated(),
                mapToGrantedAuthorities(user.getRoles()));
    }

    public static List<? extends GrantedAuthority> mapToGrantedAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList();
    }

}
