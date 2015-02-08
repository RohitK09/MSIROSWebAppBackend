package com.spring.model;

import java.util.Date;

public class VictimStatus {
	int VICTIMID;
	int STATUSID;
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
	 * @return the sTATUSID
	 */
	public int getSTATUSID() {
		return STATUSID;
	}
	/**
	 * @param i the sTATUSID to set
	 */
	public void setSTATUSID(int i) {
		STATUSID = i;
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
