package com.spring.model;

import java.util.Date;

public class Victim {
	int VICTIMID;
	String VICTIMNAME; 
	Date DECISIONDATETIME;
	/**
	 * @return the vICTIMID
	 */
	public int getVICTIMID() {
		return VICTIMID;
	}
	/**
	 * @param vICTIMID the vICTIMID to set
	 */
	public void setVICTIMID(int vICTIMID) {
		VICTIMID = vICTIMID;
	}
	/**
	 * @return the vICTIMNAME
	 */
	public String getVICTIMNAME() {
		return VICTIMNAME;
	}
	/**
	 * @param vICTIMNAME the vICTIMNAME to set
	 */
	public void setVICTIMNAME(String vICTIMNAME) {
		VICTIMNAME = vICTIMNAME;
	}
	/**
	 * @return the dECISIONDATETIME
	 */
	public Date getDECISIONDATETIME() {
		return DECISIONDATETIME;
	}
	/**
	 * @param dECISIONDATETIME the dECISIONDATETIME to set
	 */
	public void setDECISIONDATETIME(Date dECISIONDATETIME) {
		DECISIONDATETIME = dECISIONDATETIME;
	}
	
	
}
