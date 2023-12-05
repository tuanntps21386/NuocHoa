package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Product;
import com.poly.service.ProductService;

@Controller

public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product")
	public String index(Model model, @RequestParam(name = "keyword", required = false) Optional<String> keyword,
			@RequestParam(name = "cid", required = false) Optional<Integer> cid) {

		List<Product> list;

		if (keyword.isPresent()) {
			String keywordValue = keyword.get();
			if (isNumeric(keywordValue)) {
				list = productService.findByBrand(keywordValue);
			} else {
				list = productService.findByKeyword(keywordValue);
			}
		} else if (cid.isPresent()) {
			list = productService.findByCategoryId(cid.get());
		} else {
			list = productService.findAll();
		}
		model.addAttribute("items", list);
		return "product";
	}


	// Hàm kiểm tra xem một chuỗi có phải là số hay không
	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@RequestMapping("/product/chitietSP/{product_id}")
	public String detail(Model model, @PathVariable("product_id") int product_id) {
		Product item = productService.findById(product_id);
		model.addAttribute("item", item);
		return "product/chitietSP";
	}

}
