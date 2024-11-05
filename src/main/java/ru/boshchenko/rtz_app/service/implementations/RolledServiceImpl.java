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

    private final RolledRepo rolledRepo;
//    private final MappingUtilsRolled mappingUtilsRolled;
    private final RolledMapper rolledMapper;

    
    @Override
    public Rolled save(RolledDto rolledDto) {
        return rolledRepo.save(rolledMapper.toRolled(rolledDto));
    }

    @Override
    public RolledDto findByName(String name) {
        Optional<Rolled> rolled = rolledRepo.findByName(name);
        //TODO сделать исключение
        if(rolled.isPresent()){
            return rolledMapper.toRolledDto(rolled.get());
        } return null;
    }

    @Override
    public Rolled findByNameRolled(String name) {
        return rolledRepo.findByName(name).orElse(null);
    }

    @Override
    public RolledDto findById(Long id) {
        Optional<Rolled> rolled = rolledRepo.findById(id);
        //TODO сделать исключение
        if(rolled.isPresent()){
            return rolledMapper.toRolledDto(rolled.get());
        }
        return null;
    }

    @Override
    public List<RolledDto> findAll() {
        return rolledRepo.findAll().stream().map(rolledMapper::toRolledDto).toList();
    }

    @Override
    public boolean deleteById(Long id) {
        if(rolledRepo.existsById(id)){
            rolledRepo.deleteById(id);
            return true;
        } return false;
    }

    @Override
    public void delete(RolledDto rolledDto) {
        rolledRepo.delete(rolledMapper.toRolled(rolledDto));
    }

    @Override
    public boolean existsById(Long id) {
        return rolledRepo.existsById(id);
    }


    @Override
    public RolledDto update(Long id, RolledDto rolledDto) {
        Rolled rolledNew = rolledMapper.toRolled(rolledDto);
        if(rolledRepo.findById(id).isEmpty()){
            return null;
        }
        Rolled rolled = rolledRepo.findById(id).get();
        rolled.setName(rolledNew.getName());
        rolledRepo.save(rolled);
        return rolledMapper.toRolledDto(rolled);
    }

}
