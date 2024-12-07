package ru.boshchenko.rtz_app.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.model.Role;
import ru.boshchenko.rtz_app.repository.RoleRepo;
import ru.boshchenko.rtz_app.service.interfaces.RoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role findByName(String name) {
        //TODO сделать исключение
        return roleRepo.findByName(name).orElse(null);
    }

    @Override
    public Role findById(Long id) {
        //TODO сделать исключение
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        if (roleRepo.existsById(id)) {
            roleRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void delete(Role role) {
        roleRepo.delete(role);
    }

    @Override
    public boolean existsById(Long id) {
        return roleRepo.existsById(id);
    }

}
