package com.stoping.domain.model;

//1. 무지성 private 맴버 변수
//2. 필요하면 생성자 추가
//3. 무지성 getter / setter
//4. 무지성 toString()
//5. 필요하면 equals / hashCode 재정의 (오버라이드)

public class Product {
	public static void main(String[] args) {
		Product product = new Product("33", "33", 11);
		product.category = "10";
		System.out.println(product);
	}
	
	private String id;
	private String name;
	private int unitprice;
	private String description;
	private String manufacturer;
	private String category;
	private long unitInStock;
	private String condition;
	
	//overload - 똑같은 이름의 메소드를 인자만 다르게해서 받음
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
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitprice=" + unitprice + ", description=" + description
				+ ", manufacturer=" + manufacturer + ", category=" + category + ", unitInStock=" + unitInStock
				+ ", condition=" + condition + "]";
	}
	
	
	
}
