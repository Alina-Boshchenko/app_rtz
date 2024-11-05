package ru.boshchenko.rtz_app.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.UserDto;
import ru.boshchenko.rtz_app.mapper.UserMapper;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.repository.UserRepo;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;


    @Override
    public User save(UserDto userDto) {
        return userRepo.save(userMapper.toUser(userDto));
    }

    @Override
    public UserDto findByUserNameDto(String username) {
        //TODO сделать исключение
        return userMapper.toUserDto(userRepo.findByUserName(username).orElse(null));
    }

    @Override
    public User findByUserName(String username) {
        return userRepo.findByUserName(username).orElse(null);
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

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream().map(u -> userMapper.toUserDto(u)).toList();
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
        user.setUserName(userNew.getUserName());
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
