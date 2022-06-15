package com.stoping.data;

import java.util.Collections;
import java.util.List;

import com.stoping.data.dao.ProductDao;
import com.stoping.domain.model.Product;
import com.stoping.domain.repository.ProductRepository;

public class ProductRepositoryDbImpl implements ProductRepository {
	private ProductDao dao;
	
	public ProductRepositoryDbImpl(ProductDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getAll();
	}

	@Override
	public Product getProductById(String id) {
		return getAllProducts().stream()
				.filter((product) -> product.getId().equals(id))	// 조건 
				.findFirst()	// 첫번째 값
				.get();	// 얻어오기
	}

	@Override
	public void addProduct(Product product) {
		dao.insert(product);
	}

}
