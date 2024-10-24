package ru.boshchenko.rtz_app.service.implementations;

import ru.boshchenko.rtz_app.dto.RolledDto;
import ru.boshchenko.rtz_app.mapper.RolledMapper;
import ru.boshchenko.rtz_app.model.Rolled;
import ru.boshchenko.rtz_app.repository.RolledRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.service.interfaces.RolledService;
import ru.boshchenko.rtz_app.utils.MappingUtilsRolled;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolledServiceImpl implements RolledService {

    private final RolledRepo repo;
//    private final MappingUtilsRolled mappingUtilsRolled;
    private final RolledMapper rolledMapper;

    
    @Override
    public Rolled save(RolledDto rolledDto) {
        return repo.save(rolledMapper.toRolled(rolledDto));
    }

    @Override
    public RolledDto findByName(String name) {
        Optional<Rolled> rolled = repo.findByName(name);
        //TODO сделать исключение
        if(rolled.isPresent()){
            return rolledMapper.toRolledDto(rolled.get());
        } return null;
    }

    @Override
    public Rolled findByNameRolled(String name) {
        return repo.findByName(name).orElse(null);
    }

    @Override
    public RolledDto findById(Long id) {
        Optional<Rolled> rolled = repo.findById(id);
        //TODO сделать исключение
        if(rolled.isPresent()){
            return rolledMapper.toRolledDto(rolled.get());
        }
        return null;
    }

    @Override
    public List<RolledDto> findAll() {
        return repo.findAll().stream().map(rolledMapper::toRolledDto).toList();
    }

    @Override
    public boolean deleteById(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        } return false;
    }

    @Override
    public void delete(Rolled rolled) {
        repo.delete(rolled);
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }


//    @Override
//    public RolledDto update(RolledDto rolledDto) {
//        Rolled rolled = mappingUtilsRolled.toRolled(rolledDto);
//
//
//
//
//        return null;
//    }


}
