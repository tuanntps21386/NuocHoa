package com.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Order;
import com.poly.service.OrderService;



@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/thanhToan";
	}

	@RequestMapping("/order/list")
	public String list(Model model,HttpServletRequest request) {
		String username =request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}

	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id")Long id,Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
	
//	@RequestMapping("/admin/orders")
//    public String showOrderManagement(Model model) {
//        List<Order> orders = orderService.getAllOrders();
//        model.addAttribute("orders", orders);
//        return "admin/admin-orders";
//    }
//
//    @PostMapping("/updateStatus")
//    public String updateOrderStatus(@ModelAttribute("order") Order order) {
//        orderService.updateOrderStatus(order.getId(), order.getStatus());
//        return "redirect:/admin/orders";
//    }
}
