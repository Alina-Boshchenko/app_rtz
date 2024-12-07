package ru.boshchenko.rtz_app.security;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class RtzUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }
        RtzUserDetails rtzUserDetails = new RtzUserDetails(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return rtzUserDetails;
    }

}
