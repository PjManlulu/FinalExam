package ceu.HardwareStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.HardwareStore.entities.Order;
import ceu.HardwareStore.forms.OrderForm;
import ceu.HardwareStore.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Integer id) {
        return orderRepository.findById(id).get();
    }

    public OrderForm getForm(int id) {
        return new OrderForm(getById(id));
    }

    public Order save(OrderForm orderForm) {
        Order order = orderForm.getId() == null ? null : getById(orderForm.getId());
        return save(orderForm.toEntity(order));
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Integer id) {
        orderRepository.delete(getById(id));
    }

}
