package com.company.onlinestore.impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.acme.serviceavailability.impl.ServiceAvailability;
import com.company.onlinestore.Basket;
import com.company.onlinestore.Product;
import com.company.onlinestore.ThreeDeeAddOnService;

public class ThreeDeeAddOnTest {
	public static final String SVC_AVAIL="SERVICE_AVAILABLE", SVC_UNAVAIL="SERVICE_UNAVAILABLE", SVC_PLANNED="SERVICE_PLANNED", POSTCODE_INVALID="POSTCODE_INVALID";
	String postCode;
	Basket basket;
	
	
	@Before
	public void setUp() throws Exception {
		postCode="3204";
		basket=new Basket();
		basket.getProducts().add(new Product("SPORTS","SPORTS"));
		basket.getProducts().add(new Product("KIDS","KIDS"));
		basket.getProducts().add(new Product("VARIETY","VARIETY"));
		basket.getProducts().add(new Product("MOVIES_1","MOVIES"));
	}
	
	@Test
	public void testCheckFor3DAddOnProductsServiceAvailableCompatibleProducts() {
		ThreeDeeAddOnService service=new ThreeDeeAddOn(new ServiceAvailability(SVC_AVAIL));
		service.checkFor3DAddOnProducts(basket, postCode);
		assertEquals(basket.getAddOns(), new HashSet<>(Arrays.asList("MOVIES_3D_ADD_ON","SPORTS_3D_ADD_ON")));
	}
	
	@Test
	public void testCheckFor3DAddOnProductsNoPostcode() {
		postCode=null;
		ThreeDeeAddOnService service=new ThreeDeeAddOn(new ServiceAvailability(SVC_UNAVAIL));
		service.checkFor3DAddOnProducts(basket, postCode);
		assertEquals(basket.getAddOns(), new HashSet<>());
	}
	
	@Test
	public void testCheckFor3DAddOnProductsTechnicalFailure() {
		ThreeDeeAddOnService service=new ThreeDeeAddOn(new ServiceAvailability(SVC_UNAVAIL));
		service.checkFor3DAddOnProducts(basket, postCode);
		assertEquals(basket.getAddOns(), new HashSet<>());
	}

	@Test
	public void testCheckFor3DAddOnProductsInvalidePostCode() {
		ThreeDeeAddOnService service=new ThreeDeeAddOn(new ServiceAvailability(POSTCODE_INVALID));
		service.checkFor3DAddOnProducts(basket, postCode);
		assertEquals(basket.getAddOns(), new HashSet<>());
		assertEquals(basket.getServiceStatusDesc(), "The supplied postcode is invalid.");
	}

}
