package com.spring.model;



public class Ambulance {

	private String ID;
	private String vehicleNumber;
	private String ambulanceType;
	private String ProviderName;
	private int ProviderID;
	private int isAvailable ;
	/**
	 * @return the ambulanceProviderID
	 */
	public int getAmbulanceProviderID() {
		return ProviderID;
	}

	/**
	 * @param ambulanceProviderID the ambulanceProviderID to set
	 */
	public void setAmbulanceProviderID(int ambulanceProviderID) {
		this.ProviderID = ambulanceProviderID;
	}

	/**
	 * @return the isAvailable
	 */
	public int getIsAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	//private String ambulance
	/**
	 * @return the iD
	 */
	public String getID() {
	
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	

	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber
	 *            the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the ambulanceType
	 */
	public String getAmbulanceType() {
		return ambulanceType;
	}

	/**
	 * @param ambulanceType
	 *            the ambulanceType to set
	 */
	public void setAmbulanceType(String ambulanceType) {
		this.ambulanceType = ambulanceType;
	}

	/**
	 * @return the ambulanceProviderName
	 */
	public String getAmbulanceProviderName() {
		return ProviderName;
	}

	/**
	 * @param ambulanceProviderName
	 *            the ambulanceProviderName to set
	 */
	public void setAmbulanceProviderName(String ambulanceProviderName) {
		this.ProviderName = ambulanceProviderName;
	}
	@Override
	public String toString() {
		return "{ID="+ID+",AmbulanceProvderName="+ProviderName+",AmbulanceType="+ambulanceType+",VehicleNumber="+vehicleNumber+"}";
	}
	
}