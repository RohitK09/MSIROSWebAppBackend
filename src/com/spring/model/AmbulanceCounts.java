package com.spring.model;

public class AmbulanceCounts {
 private int ProviderId;
 private String AmbulanceType;
 private int NumberOfAmbulance;


/**
 * @return the ambulanceType
 */
public String getAmbulanceType() {
	return AmbulanceType;
}
/**
 * @param ambulanceType the ambulanceType to set
 */
public void setAmbulanceType(String ambulanceType) {
	AmbulanceType = ambulanceType;
}
/**
 * @return the numberOfAmbulance
 */
/**
 * @return the numberOfAmbulance
 */
public int getNumberOfAmbulance() {
	return NumberOfAmbulance;
}
/**
 * @param numberOfAmbulance the numberOfAmbulance to set
 */
public void setNumberOfAmbulance(int numberOfAmbulance) {
	NumberOfAmbulance = numberOfAmbulance;
}
public int getProviderId() {
	return ProviderId;
}
public void setProviderId(int providerId) {
	ProviderId = providerId;
}

@Override
public String toString() {
	return "{providerId="+ProviderId+",numberOfAmbulances="+NumberOfAmbulance+",AmbulanceType"+AmbulanceType+"}";
}
}
