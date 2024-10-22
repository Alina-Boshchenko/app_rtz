package ru.boshchenko.rtz_app.utils;

import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.dto.RolledDto;
import ru.boshchenko.rtz_app.model.Rolled;

@Component
public class MappingUtilsRolled {

    public Rolled toRolled(RolledDto rolledDto) {
        return Rolled.builder().name(rolledDto.getName()).build();
    }
    public RolledDto toRolledDto(Rolled rolled){
        return RolledDto.builder().name(rolled.getName()).build();
    }


}
