package com.stoping.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.stoping.domain.model.Product;

public class ProductRepository {
	
//	public static void main(String[] args) {
//		// ArrayList - 일반적인 배열, 크기가 클수록 느려짐, 내부적으로 배열이라 성능이 빠르다.
//		// LinkedList - 연결 배열, 삽입 삭제가 빈번할 때 유리, but 검색이 느리다. 메모리가 좀더 크다
//		// List - interface, 기능이 정의 되어있지 않은 상태, 다형성
//		
//		LinkedList<Product> products = new LinkedList<>();
//		
//		ArrayList<Product> products2 = new ArrayList<>();
//		
//		sort(products);
//		sort(products2);
//	}
//	
//	public static List<Product> sort(List<Product> Products) {
//		return new ArrayList<>();
//	}
	
	private List<Product> products = new ArrayList<>();
	
	//싱글턴 패턴
	// 1. static 인스턴스 준비
	// 2. static 매서드로 인스턴스 리턴 (getInstance() 이름을 주로 씀)
	// 3. 생성자 막기 (private)
	private static ProductRepository instance = new ProductRepository();
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Retina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		notebook.setDescription("!4.7-inch, 1334x750 Retina HD display");
		notebook.setCategory("!Smart Phone");
		notebook.setManufacturer("!Apple");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refubished");
		
		Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("?4.7-inch, 1334x750 Retina HD display");
		tablet.setCategory("?Smart Phone");
		tablet.setManufacturer("?Apple");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		
		products.add(phone);
		products.add(notebook);
		products.add(tablet);
	}
	
	// 모든 상품 정보를 리턴
	public List<Product> getAllProducts() {
		return products;
	}
	
	public Product getProductById(String id) {
		// List -> Steam (데이터의 흐름)
		return products.stream()
					.filter((product) -> product.getId().equals(id))	// 조건 
					.findFirst()	// 첫번째 값
					.get();	// 얻어오기
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
}
