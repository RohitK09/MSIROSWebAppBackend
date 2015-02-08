package com.spring.model;

import java.sql.Date;
/*
 * Models the Incident class
 * 
 */
public class Incident {
	private int INCIDENTID;
	private Date INCIDENTDATE;
	private double LONGITUDE;
	private double LATITUDE;
	private String  LOCATIONNAME;
	/**
	 * @return the iNCIDENTID
	 */
	public int getINCIDENTID() {
		return INCIDENTID;
	}
	/**
	 * @param iNCIDENTID the iNCIDENTID to set
	 */
	public void setINCIDENTID(int iNCIDENTID) {
		INCIDENTID = iNCIDENTID;
	}
	/**
	 * @return the iNCIDENTDATE
	 */
	public Date getINCIDENTDATE() {
		return INCIDENTDATE;
	}
	/**
	 * @param iNCIDENTDATE the iNCIDENTDATE to set
	 */
	public void setINCIDENTDATE(Date iNCIDENTDATE) {
		INCIDENTDATE = iNCIDENTDATE;
	}
	/**
	 * @return the lONGITUDE
	 */
	public double getLONGITUDE() {
		return LONGITUDE;
	}
	/**
	 * @param lONGITUDE the lONGITUDE to set
	 */
	public void setLONGITUDE(double lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	/**
	 * @return the lATITUDE
	 */
	public double getLATITUDE() {
		return LATITUDE;
	}
	/**
	 * @param lATITUDE the lATITUDE to set
	 */
	public void setLATITUDE(double lATITUDE) {
		LATITUDE = lATITUDE;
	}
	/**
	 * @return the lOCATIONNAME
	 */
	public String getLOCATIONNAME() {
		return LOCATIONNAME;
	}
	/**
	 * @param lOCATIONNAME the lOCATIONNAME to set
	 */
	public void setLOCATIONNAME(String lOCATIONNAME) {
		LOCATIONNAME = lOCATIONNAME;
	}

}
