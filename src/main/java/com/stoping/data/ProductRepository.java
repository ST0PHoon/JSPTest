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
	
	public ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Retina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitInStock(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC 그램", 1500000);
		notebook.setDescription("!4.7-inch, 1334x750 Retina HD display");
		notebook.setCategory("!Smart Phone");
		notebook.setManufacturer("!Apple");
		notebook.setUnitInStock(1000);
		notebook.setCondition("Refubished");
		
		Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("?4.7-inch, 1334x750 Retina HD display");
		tablet.setCategory("?Smart Phone");
		tablet.setManufacturer("?Apple");
		tablet.setUnitInStock(1000);
		tablet.setCondition("Old");
		
		products.add(phone);
		products.add(notebook);
		products.add(tablet);
	}
	
	// 모든 상품 정보를 리턴
	public List<Product> getAllProducts() {
		return products;
	}
}
