package com.stoping.data.dao;

import java.util.List;

import com.stoping.domain.model.Product;

//Data Access Object
//DB랑 연결할 놈
public interface ProductDao {
	// interface 안에서는 public생략, public만 사용가능
	List<Product> getAll();
	
	void insert(Product product);
	
	void update(Product product);
	
	void delete(Product product);
}
