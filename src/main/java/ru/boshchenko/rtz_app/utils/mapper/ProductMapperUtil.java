package ru.boshchenko.rtz_app.utils.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.model.Rolled;
import ru.boshchenko.rtz_app.model.Standard;
import ru.boshchenko.rtz_app.model.SteelGrade;
import ru.boshchenko.rtz_app.model.TypeProduct;
import ru.boshchenko.rtz_app.service.interfaces.RolledService;
import ru.boshchenko.rtz_app.service.interfaces.StandardService;
import ru.boshchenko.rtz_app.service.interfaces.SteelGradeService;
import ru.boshchenko.rtz_app.service.interfaces.TypeProductService;

@Named("ProductMapperUtil")
@Component
@RequiredArgsConstructor
public class ProductMapperUtil {

    private final RolledService rolledService;
    private final TypeProductService typeProductService;
    private final StandardService standardService;
    private final SteelGradeService steelGradeService;

    @Named("getRolledByName")
    public Rolled getRolledByName(String name){
       return rolledService.findByNameRolled(name);
    }

    @Named("getTypeProductByName")
    public TypeProduct getTypeProductByName(String name){
        return typeProductService.findByNameTypeProduct(name);
    }
    @Named("getStandardByName")
    public Standard getStandardByName(String name){
        return standardService.findByNameStandard(name);
    }
    @Named("getSteelGradeByName")
    public SteelGrade getSteelGradeByName(String name){
        return steelGradeService.findByNameSteelGrade(name);
    }

    @Named("getNameRolled")
    public String getNameRolled(Rolled rolled){
        return rolled.getName();
    }
    @Named("getNameTypeProduct")
    public String getNameTypeProduct(TypeProduct typeProduct){
        return typeProduct.getName();
    }
    @Named("getNameStandard")
    public String getNameStandard(Standard standard){
        return standard.getName();
    }
    @Named("getNameSteelGrade")
    public String getNameSteelGrade(SteelGrade steelGrade){
        return steelGrade.getName();
    }
}
