package com.company.onlinestore;

public class Product {

	private String type;
	private String category;
	
	public Product() {
	}
	public Product(String type, String category) {
		this.type = type;
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
