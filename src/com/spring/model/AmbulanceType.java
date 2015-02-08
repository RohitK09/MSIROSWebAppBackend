package com.spring.model;

public class AmbulanceType {
	
	private String ambulanceType ;
	private int count ;
	public String getAmbulanceType() {
		return ambulanceType;
	}
	public void setAmbulanceType(String ambulanceType) {
		this.ambulanceType = ambulanceType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	   public String toString()
	   {
	      return "ambulancesCount [ambulanceType=" + ambulanceType+ ","+  "count=" + count + "]";
	   }
}
