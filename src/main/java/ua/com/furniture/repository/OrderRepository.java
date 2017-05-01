package ua.com.furniture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.furniture.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
