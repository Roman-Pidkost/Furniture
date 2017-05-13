package ua.com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.furniture.entity.Order;
import ua.com.furniture.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(OrderController.URL)
public class OrderController {
    static final String URL = "/api/order";

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> get() {
        return orderService.findAll();
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping
    public Order update(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }

}
