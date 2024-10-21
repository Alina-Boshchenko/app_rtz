package ru.boshchenko.rtz_app.service;

import org.springframework.stereotype.Service;

import ru.boshchenko.rtz_app.model.Role;

import java.util.List;

@Service
public interface RoleService {
    Role save(Role role);
    Role findByName(String name);
    Role findById(Long id);
    List<Role> findAll();
    boolean deleteById(Long id);

    void delete(Role role);

    boolean existsById(Long id);

}
