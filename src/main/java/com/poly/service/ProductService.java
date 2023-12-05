package com.poly.service;

import java.util.List;

import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(int product_id);

	List<Product> findByKeyword(String keyword);

	List<Product> findByBrand(String keyword);

	Product create(Product product);

	Product update(Product product);

	List<Product> findByCategoryId(Integer id);

	void delete(Integer product_id);

}
