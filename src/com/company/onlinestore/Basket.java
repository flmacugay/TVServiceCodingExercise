package com.company.onlinestore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Basket {
	private List<Product> products;
	private Set<String> addOns;
	private String serviceStatus;
	private String serviceStatusDesc;
	
	public Basket() {
		products=new ArrayList<>();
		addOns=new HashSet<>();
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Set<String> getAddOns() {
		return addOns;
	}
	public void setAddOns(Set<String> addOns) {
		this.addOns = addOns;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public String getServiceStatusDesc() {
		return serviceStatusDesc;
	}
	public void setServiceStatusDesc(String serviceStatusDesc) {
		this.serviceStatusDesc = serviceStatusDesc;
	}

}
