package ru.boshchenko.rtz_app.service.interfaces;

import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.model.User;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    User findByUserName(String username);
    User findByEmail(String email);

    /**
     * @param inn - ИНН организации
     * @return сущность записи в БД
     */
    User findByInn(Long inn);

    User findById(Long id);

    List<User> findAll();

    boolean deleteById(Long id);

    void delete(User user);

    boolean existsById(Long id);

}
