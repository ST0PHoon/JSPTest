package com.stoping.domain.model;

import java.util.Objects;

//1. 무지성 private 맴버 변수
//2. 필요하면 생성자 추가
//3. 무지성 getter / setter
//4. 무지성 toString()
//5. 필요하면 equals / hashCode 재정의 (오버라이드)

public class Product {
	public static void main(String[] args) {
		Product product = new Product("33", "33", 11);
		System.out.println(product);
		
		Product product2 = new Product("33", "33", 11);
		System.out.println(product2);
		
		// == : 주소비교, hasCode()가 같아야한다. 내용이 같더라도 다를 수 있다.
		// equals : Object 로 받아와서 비교,  모든 클래스는 Object(타입을 가리지 않음)를 상속받는다.(extends),
		// Object object = new Product("33", "33", 11); 도 가능하다.
		// product.equals(product2); // true - 재정의함
		// product.hashCode() == product2.hashCode(); //true 재정의 
		// product == product2 // false
	}
	
	private String id;
	private String name;
	private int unitprice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitInStock;
	private String condition;
	
	//overload - 똑같은 이름의 메소드를 인자만 다르게해서 받음 / override 재정의
	public Product(String id, String name, int unitprice) {
		this.id = id;
		this.name = name;
		this.unitprice = unitprice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(long unitInStock) {
		this.unitInStock = unitInStock;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitprice=" + unitprice + ", description=" + description
				+ ", manufacturer=" + manufacturer + ", category=" + category + ", unitInStock=" + unitInStock
				+ ", condition=" + condition + "]";
	}
	
	
	
}
