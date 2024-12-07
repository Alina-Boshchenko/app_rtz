package ru.boshchenko.rtz_app.service.implementations;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.boshchenko.rtz_app.dto.OrderDto;
import ru.boshchenko.rtz_app.mapper.OrderMapper;
import ru.boshchenko.rtz_app.model.Order;
import ru.boshchenko.rtz_app.repository.OrderRepo;
import ru.boshchenko.rtz_app.service.interfaces.OrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;

    @Override
    public Order save(OrderDto orderDto) {
        return orderRepo.save(orderMapper.toOrder(orderDto));
    }

    @Override
    public OrderDto findById(Long id) {
        return orderMapper.toOrderDto(orderRepo.findById(id).orElse(null));
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepo.findAll().stream().map(orderMapper::toOrderDto).toList();
    }

    @Override
    public boolean deleteById(Long id) {
        if (orderRepo.existsById(id)) {
            orderRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void delete(OrderDto orderDto) {
        orderRepo.delete(orderMapper.toOrder(orderDto));
    }

    @Override
    public boolean existsById(Long id) {
        return orderRepo.existsById(id);
    }

    @Override
    public OrderDto updateById(Long id, OrderDto orderDto) {
        Order orderNew = orderMapper.toOrder(orderDto);
        if (orderRepo.findById(id).isPresent()) {
            return null;
        }
        Order order = orderRepo.findById(id).get();
        order.setProducts(orderNew.getProducts());
        order.setNeedInvoice(orderNew.isNeedInvoice());
        order.setAmount(orderNew.getAmount());
        order.setUser(orderNew.getUser());
        orderRepo.save(order);
        return orderMapper.toOrderDto(order);
    }

}
