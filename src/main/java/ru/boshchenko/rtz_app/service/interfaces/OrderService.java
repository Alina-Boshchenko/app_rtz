package ru.boshchenko.rtz_app.service.interfaces;

import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.OrderDto;
import ru.boshchenko.rtz_app.model.Order;

import java.util.List;

@Service
public interface OrderService {

    Order save(OrderDto orderDto);

    OrderDto findById(Long id);

    List<OrderDto> findAll();

    boolean deleteById(Long id);

    void delete(OrderDto orderDto);

    boolean existsById(Long id);

    OrderDto updateById(Long id, OrderDto orderDto);

}
