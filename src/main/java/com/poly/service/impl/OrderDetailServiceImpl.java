package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDetailDAO;
import com.poly.entity.OrderDetail;
import com.poly.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
    OrderDetailDAO orderDetaiDAO;

	@Override
	public OrderDetail getOrderDetail(Long orderId) {
		return orderDetaiDAO.findById(orderId).orElse(null);
	}

    
}
