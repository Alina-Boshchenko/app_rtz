package ru.boshchenko.rtz_app.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.repository.UserRepo;
import ru.boshchenko.rtz_app.service.interfaces.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;


    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findByUserName(String username) {
        //TODO сделать исключение
        return userRepo.findByUserName(username).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        //TODO сделать исключение
        return userRepo.findByEmail(email).orElse(null);
    }

    @Override
    public User findByInn(Long inn) {
        //TODO сделать исключение
        return userRepo.findByInn(inn).orElse(null);
    }

    @Override
    public User findById(Long id) {
        //TODO сделать исключение
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
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
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }
}
