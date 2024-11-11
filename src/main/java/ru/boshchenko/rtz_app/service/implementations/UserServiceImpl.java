package ru.boshchenko.rtz_app.service.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.UserDto;
import ru.boshchenko.rtz_app.mapper.UserMapper;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.repository.UserRepo;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final UserMapper userMapper;


    @Override
    public User save(UserDto userDto) {
        return userRepo.save(userMapper.toUser(userDto));
    }

    @Override
    public UserDto findByUsernameDto(String username) {
        //TODO сделать исключение
        return userMapper.toUserDto(userRepo.findByUsername(username).orElse(null));
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь %s не найден", username)
        ));
    }

//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = findByUserName(username);
//        return new org.springframework.security.core.userdetails.User(
//                user.getUserName(),
//                user.getPassword(),
//                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
//                        .collect(Collectors.toList())
//        );
//    }


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

/** логирование */
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
        if(userRepo.findById(id).isEmpty()){
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
