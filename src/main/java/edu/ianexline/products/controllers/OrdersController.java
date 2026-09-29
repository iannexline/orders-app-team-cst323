package edu.ianexline.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ianexline.products.data.OrdersDataService;
import edu.ianexline.products.models.OrderModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    // dependency injection: Spring hands us the data service
    @Autowired
    private OrdersDataService ordersService;

    // show all orders at /orders
    @GetMapping("")
    public String showAllOrders(Model model) {
        model.addAttribute("title", "All Orders");
        model.addAttribute("orders", ordersService.getAll());
        return "allOrders";
    }

    // show one order at /orders/showOrder/3
    @GetMapping("/showOrder/{id}")
    public String showOrder(@PathVariable("id") int id, Model model) {
        OrderModel order = ordersService.getById(id);
        model.addAttribute("title", "Order Details");
        model.addAttribute("order", order);
        return "showOrder";
    }

    // show the edit form at /orders/editOrder/3
    @GetMapping("/editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, Model model) {
        OrderModel order = ordersService.getById(id);
        model.addAttribute("title", "Edit Order");
        model.addAttribute("order", order);
        return "editOrder";
    }

    // handle the edit form submit
    @PostMapping("/processEditOrder")
    public String processEditOrder(@ModelAttribute OrderModel order) {
        ordersService.update(order);
        return "redirect:/orders";
    }

    // show the new order form at /orders/newOrder
    @GetMapping("/newOrder")
    public String newOrder(Model model) {
        model.addAttribute("title", "New Order");
        model.addAttribute("order", new OrderModel());
        return "newOrder";
    }

    // handle the new order form submit
    @PostMapping("/processNewOrder")
    public String processNewOrder(@ModelAttribute OrderModel order) {
        ordersService.create(order);
        return "redirect:/orders";
    }

    // delete an order at /orders/deleteOrder/3
    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        ordersService.deleteById(id);
        return "redirect:/orders";
    }
}