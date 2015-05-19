package com.spring.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.spring.model.Hospital;
 
public class HospitalRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hospital hospital = new Hospital();
		hospital.setHospitalId(rs.getInt("HOSPITAL_ID"));
		hospital.setHospitalName(rs.getString("HOSPITAL_NAME"));
		hospital.setNumberOfBeds(rs.getInt("BEDS_AVAILABLE"));
		//hospital.setDistance(rs.getInt("DISTANCE"));
		//hospital.setNumberOfBedsOcuupied(rs.getInt("NUMBEROFBEDSOCCUPIED"));
		//hospital.setTraumaLevel(rs.getString("TRAUMA_LEVEL"));
		return hospital;
	}
 
}