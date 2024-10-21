package ru.boshchenko.rtz_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boshchenko.rtz_app.model.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByInn(Long inn);
}
