package ua.com.furniture.service;

import ua.com.furniture.entity.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);
    List<Order> findAll();
    Order findOne(int id);
    void delete(int id);
}
