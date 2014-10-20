package com.acme.serviceavailability.impl;

import java.util.HashMap;
import java.util.Map;

import com.acme.serviceavailability.AvailabilityChecker;
import com.acme.serviceavailability.TechnicalFailureException;

public class ServiceAvailability implements AvailabilityChecker {

	public static final String SVC_AVAIL="SERVICE_AVAILABLE", SVC_UNAVAIL="SERVICE_UNAVAILABLE", SVC_PLANNED="SERVICE_PLANNED", POSTCODE_INVALID="POSTCODE_INVALID";
	public static final Map<String, String> DESC_MAP=getStatusDesc();
	private String serviceStatus="";

	public ServiceAvailability() {
		this.serviceStatus = SVC_UNAVAIL;
	}

	public ServiceAvailability(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	@Override
	public String isPostCodeIn3DTVServiceArea(String postCode)
			throws TechnicalFailureException {

		if(serviceStatus==null || serviceStatus.equalsIgnoreCase(SVC_UNAVAIL))
			throw new TechnicalFailureException();

		return serviceStatus;
	}

	public void cleanup() {
		System.out.println("Cleanup connections");
	}
	
	private static Map<String, String> getStatusDesc(){
		Map<String, String> map=new HashMap<>();
		map.put(SVC_AVAIL, "3DTV service is available for the given post code.");
		map.put(SVC_UNAVAIL, "3DTV service is unavailable for the given post code.");
		map.put(SVC_PLANNED, "3DTV service is not available right now, but it should be available within the next 3 months.");
		map.put(POSTCODE_INVALID, "The supplied postcode is invalid.");
		return map;
	}

}
