package ru.boshchenko.rtz_app.utils.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.boshchenko.rtz_app.model.Product;
import ru.boshchenko.rtz_app.model.User;
import ru.boshchenko.rtz_app.repository.ProductRepo;
import ru.boshchenko.rtz_app.repository.UserRepo;

import java.util.Collection;

@Named("OrderMapperUtil")
@Component
@RequiredArgsConstructor
public class OrderMapperUtil {

    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    @Named("getIdProducts")
    public Collection<Long> getIdProducts(Collection<Product> products) {
        if (products == null) {
            return null;
        }
        return products.stream().map(Product::getId).toList();
    }

    @Named("getProducts")
    public Collection<Product> getProducts(Collection<Long> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> productRepo.findById(id).orElse(null)).toList();
    }

    @Named("getUserId")
    public Long getUserId(User user) {
        if (user == null) {
            return null;
        }
        return user.getId();
    }

    @Named("getUser")
    public User getUser(Long userId) {
        if (userId == null) {
            return null;
        }
        return userRepo.findById(userId).orElse(null);
    }

}
