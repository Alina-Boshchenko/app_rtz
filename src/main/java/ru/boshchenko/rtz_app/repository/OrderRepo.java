package ru.boshchenko.rtz_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boshchenko.rtz_app.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
