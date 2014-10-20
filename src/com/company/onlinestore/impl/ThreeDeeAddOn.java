package com.company.onlinestore.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.acme.serviceavailability.AvailabilityChecker;
import com.acme.serviceavailability.TechnicalFailureException;
import com.acme.serviceavailability.impl.ServiceAvailability;
import com.company.onlinestore.Basket;
import com.company.onlinestore.Product;
import com.company.onlinestore.ThreeDeeAddOnService;

public class ThreeDeeAddOn implements ThreeDeeAddOnService {
	
	public static final String SPORTS_3D="SPORTS_3D_ADD_ON", NEWS_3D="NEWS_3D_ADD_ON", MOVIES_3D="MOVIES_3D_ADD_ON";
	public static final String SPORTS_CAT="SPORTS", KIDS_CAT="KIDS", VAR_CAT="VARIETY", NEWS_CAT="NEWS", MOVIES_CAT="MOVIES";
	private AvailabilityChecker ac;
	
	public ThreeDeeAddOn() {
		ac=new ServiceAvailability();
	}
	
	public ThreeDeeAddOn(AvailabilityChecker ac) {
		this.ac=ac;
	}

	@Override
	public void checkFor3DAddOnProducts(Basket basket, String postCode) {
		String serviceStatus = null;
		try {
			serviceStatus = ac.isPostCodeIn3DTVServiceArea(postCode);
		} catch (TechnicalFailureException e) {
			serviceStatus=ServiceAvailability.SVC_UNAVAIL;
		} finally {
			// to do : cleanup connections used by AvailabilityChecker
			basket.setServiceStatus(serviceStatus);
			basket.setServiceStatusDesc(ServiceAvailability.DESC_MAP.get(serviceStatus));
		}
		
		
		if(serviceStatus.equalsIgnoreCase(ServiceAvailability.SVC_AVAIL)) {
			basket.setAddOns(getRelevantAddOns(basket));
		}
	}

	private Set<String> getRelevantAddOns(Basket basket){
		Set<String> relevantAddOns=new HashSet<>();
		List<Product> products = basket.getProducts();
		for(Iterator<Product> iter=products.iterator();iter.hasNext();) {
			Product product=iter.next();
			String cat=product.getCategory();
			
			switch (cat) {
			case SPORTS_CAT:
				relevantAddOns.add(SPORTS_3D);
				break;
			case NEWS_CAT:
				relevantAddOns.add(NEWS_3D);
				break;
			case MOVIES_CAT:
				relevantAddOns.add(MOVIES_3D);
				break;
			default:
				break;
			}
		}
		return relevantAddOns;
	}

}
