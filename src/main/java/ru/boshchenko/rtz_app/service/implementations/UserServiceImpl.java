package ru.boshchenko.rtz_app.service.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.UserDto;
import ru.boshchenko.rtz_app.mapper.UserMapper;
import ru.boshchenko.rtz_app.model.Role;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.repository.RoleRepo;
import ru.boshchenko.rtz_app.repository.UserRepo;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userMapper.toUser(userDto);
        Role role = new Role("ROLE_USER");
        roleRepo.save(role);
        user.setRoles(Set.of(role));
        return userRepo.save(user);
    }

    @Override
    public UserDto findByUsernameDto(String username) {
        //TODO сделать исключение
        return userMapper.toUserDto(userRepo.findByUsername(username).orElse(null));
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    @Override
    public UserDto findByEmail(String email) {
        //TODO сделать исключение
        return userMapper.toUserDto(userRepo.findByEmail(email).orElse(null));
    }

    @Override
    public UserDto findByInn(Long inn) {
        //TODO сделать исключение
        return userMapper.toUserDto(userRepo.findByInn(inn).orElse(null));
    }

    @Override
    public UserDto findById(Long id) {
        //TODO сделать исключение
        return userMapper.toUserDto(userRepo.findById(id).orElse(null));
    }

    /**
     * логирование
     */
    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtoList = userRepo.findAll().stream().map(userMapper::toUserDto).toList();
        log.info("IN findAll - {} users", userDtoList.size());
        return userDtoList;
    }

    @Override
    public boolean deleteById(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void delete(UserDto userDto) {
        userRepo.delete(userMapper.toUser(userDto));
    }

    @Override
    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User userNew = userMapper.toUser(userDto);
        if (userRepo.findById(id).isEmpty()) {
            return null;
        }
        User user = userRepo.findById(id).get();
        user.setUsername(userNew.getUsername());
        user.setFirstName(userNew.getFirstName());
        user.setLastName(userNew.getLastName());
        user.setPatronymic(userNew.getPatronymic());
        user.setEmail(userNew.getEmail());
        user.setPhone(userNew.getPhone());
        user.setInn(userNew.getInn());
        userRepo.save(user);
        return userMapper.toUserDto(user);
    }

}
