package ceu.HardwareStore.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ceu.HardwareStore.entities.Order;
import ceu.HardwareStore.forms.OrderForm;
import ceu.HardwareStore.services.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String index(Model model) {
        List<Order> orders = orderService.getAll();

        model.addAttribute("orders", orders);
        return "/views/order/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        return "/views/order/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        OrderForm orderForm = orderService.getForm(id);
        model.addAttribute("orderForm", orderForm);
        return "/views/order/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        orderService.delete(id);
        return String.format("redirect:/%s/", "order");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute OrderForm orderForm) {
        orderService.save(orderForm);
        return String.format("redirect:/%s/", "order");
    }

}

