package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Order;
import com.poly.service.OrderService;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrderController {
	@Autowired
    private OrderService orderService;

    @GetMapping
    public String showOrderManagement(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/admin-orders";
    }
    
//    @PostMapping("/updateStatus/{id}")
//    public String updateOrderStatus(@ModelAttribute("order") Order order) {
//        orderService.updateOrderStatus(order.getId(), order.getStatus());
//        return "redirect:/admin/orders";
//    }

//
//    @PostMapping("/updateStatus")
//    public String updateOrderStatus(@RequestParam("id") Long id, @RequestParam("status") String status) {
//        orderService.updateOrderStatus(id, status);
//        return "redirect:/admin/orders";
//    }


}
