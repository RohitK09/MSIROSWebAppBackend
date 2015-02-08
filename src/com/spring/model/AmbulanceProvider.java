package com.spring.model;
/*
 * Ambulance Provider Entity
 * Has Mapping between the provider Id and 
 * the Provider Name
 */
public class AmbulanceProvider {
	private int ProviderId ;
	private String ProviderName;
	public int getProviderId() {
		return ProviderId;
	}
	public void setProviderId(int providerId) {
		ProviderId = providerId;
	}
	public String getProviderName() {
		return ProviderName;
	}
	public void setProviderName(String providerName) {
		ProviderName = providerName;
	}
	@Override
	public String toString() {
		return "{providerId="+ProviderId+",ambulanceProvderName="+ProviderName+"}";
	}
}
