package ru.boshchenko.rtz_app.service;

import ru.boshchenko.rtz_app.model.Rolled;
import ru.boshchenko.rtz_app.repository.RolledRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolledServiceImpl implements RolledService {

    private final RolledRepo repo;




    @Override
    public Rolled save(Rolled rolled) {
        return repo.save(rolled);
    }

    @Override
    public Rolled findByName(String name) {
        Optional<Rolled> rolled = repo.findByName(name);
        //TODO сделать исключение
        if(rolled.isPresent()){
            return rolled.get();
        } return null;
    }

    @Override
    public Rolled findById(Long id) {
        Optional<Rolled> rolled = repo.findById(id);
        //TODO сделать исключение
        if(rolled.isPresent()){return rolled.get();}
        return null;
    }

    @Override
    public List<Rolled> findAll() {
        List<Rolled> rolleds = repo.findAll();
        return rolleds;
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
//    public Rolled update(Rolled rolled) {
//        Optional<Rolled> rolledNew = repo.update(rolled);
//        //TODO сделать исключение
//        if(rolledNew.isPresent()){
//            return rolledNew.get();
//        } return null;
//    }
}
