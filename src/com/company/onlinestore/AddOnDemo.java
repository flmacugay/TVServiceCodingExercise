package com.company.onlinestore;

import com.acme.serviceavailability.impl.ServiceAvailability;
import com.company.onlinestore.impl.ThreeDeeAddOn;

public class AddOnDemo {

	public static void main(String[] args) {
		String postCode="3204";
		postCode=null;
		Basket basket=new Basket();
		basket.getProducts().add(new Product("SPORTS","SPORTS"));
		basket.getProducts().add(new Product("KIDS","KIDS"));
		basket.getProducts().add(new Product("VARIETY","VARIETY"));
		basket.getProducts().add(new Product("MOVIES_1","MOVIES"));
		
		ThreeDeeAddOnService service=new ThreeDeeAddOn(new ServiceAvailability("SERVICE_AVAILABLE"));
		service.checkFor3DAddOnProducts(basket, postCode);
		
		System.out.printf("Service status for postcode %s is %s \n", postCode, basket.getServiceStatus());
		System.out.println(basket.getServiceStatusDesc());
		for (String addOnString : basket.getAddOns()) {
			System.out.println("Add on : "+ addOnString);
		}
	}

}
