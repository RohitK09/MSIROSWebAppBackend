package com.spring.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



public class Hospital {

	private int HospitalId ; 
	private String HospitalName;
	private int NumberOfBeds;
	private int Distance;
	private int NumberOfBedsOcuupied;
	private String TraumaLevel;
	/**
	 * @return the hospitalId
	 */
	public int getHospitalId() {
		return HospitalId;
	}
	@Autowired
    public void init(DataSource dataSource) {
       // this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	/**
	 * @param hospitalId the hospitalId to set
	 */
	public void setHospitalId(int hospitalId) {
		HospitalId = hospitalId;
	}

	/**
	 * @return the hospitalName
	 */
	public String getHospitalName() {
		return HospitalName;
	}

	/**
	 * @param hospitalName the hospitalName to set
	 */
	public void setHospitalName(String hospitalName) {
		HospitalName = hospitalName;
	}

	/**
	 * @return the numberOfBeds
	 */
	public int getNumberOfBeds() {
		return NumberOfBeds;
	}

	/**
	 * @param numberOfBeds the numberOfBeds to set
	 */
	public void setNumberOfBeds(int numberOfBeds) {
		NumberOfBeds = numberOfBeds;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return Distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		Distance = distance;
	}

	/**
	 * @return the numberOfBedsOcuupied
	 */
	public int getNumberOfBedsOcuupied() {
		return NumberOfBedsOcuupied;
	}

	/**
	 * @param numberOfBedsOcuupied the numberOfBedsOcuupied to set
	 */
	public void setNumberOfBedsOcuupied(int numberOfBedsOcuupied) {
		NumberOfBedsOcuupied = numberOfBedsOcuupied;
	}

	/**
	 * @return the traumaLevel
	 */
	public String getTraumaLevel() {
		return TraumaLevel;
	}

	/**
	 * @param string the traumaLevel to set
	 */
	public void setTraumaLevel(String string) {
		TraumaLevel = string;
	}

	
	
}
