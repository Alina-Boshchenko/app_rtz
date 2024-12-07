package ru.boshchenko.rtz_app.service.interfaces;

import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.UserDto;
import ru.boshchenko.rtz_app.model.User;

import java.util.List;

@Service
public interface UserService {

    User save(UserDto userDto);

    UserDto findByUsernameDto(String username);

    User findByUsername(String username);

    UserDto findByEmail(String email);

    /**
     * @param inn - ИНН организации
     * @return сущность записи в БД
     */
    UserDto findByInn(Long inn);

    UserDto findById(Long id);

    List<UserDto> findAll();

    boolean deleteById(Long id);

    void delete(UserDto userDto);

    boolean existsById(Long id);

    UserDto updateUser(Long id, UserDto userDto);

}
