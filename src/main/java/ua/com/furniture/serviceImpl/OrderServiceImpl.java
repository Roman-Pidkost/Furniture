package ua.com.furniture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.furniture.entity.Order;
import ua.com.furniture.repository.OrderRepository;
import ua.com.furniture.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOne(int id) {
        return orderRepository.findOne(id);
    }

    public void delete(int id) {
        orderRepository.delete(id);
    }
}
