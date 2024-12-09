package ru.boshchenko.rtz_app.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.boshchenko.rtz_app.dto.OrderDto;
import ru.boshchenko.rtz_app.service.interfaces.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.findAll();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long id) {
        if (orderService.existsById(id)) {
            return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        if (orderService.updateById(id, orderDto) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.updateById(id, orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        if (!orderService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.deleteById(id);
        return new ResponseEntity<>("It's ok delete order", HttpStatus.OK);
    }
}
