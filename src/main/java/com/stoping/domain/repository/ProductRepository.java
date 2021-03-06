package com.stoping.domain.repository;

import java.util.List;
import com.stoping.data.ProductRepositoryDbImpl;
import com.stoping.data.ProductRepositoryImpl;
import com.stoping.data.dao.MySqlProductDaoImpl;
import com.stoping.domain.model.Product;

// 공통기능을 미리 정의한다. interface
public interface ProductRepository {
	
	public static ProductRepository getInstance() {
		// 메모리에 붙음
		return ProductRepositoryImpl.getInstance();
		// DB에 붙음
//		return new ProductRepositoryDbImpl(new MySqlProductDaoImpl());
	}
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String id);
	
	public void addProduct(Product product);
}
