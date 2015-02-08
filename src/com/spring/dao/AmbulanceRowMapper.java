package com.spring.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Ambulance;
 
public class AmbulanceRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ambulance ambulance = new Ambulance();
		ambulance.setID(rs.getString("AMBULANCEID"));
		ambulance.setAmbulanceType(rs.getString("AMBULANCETYPE"));
		ambulance.setVehicleNumber(rs.getString("VEHICLENO"));
		ambulance.setAmbulanceProviderName(rs.getString("AMBULANCEPROVIDERNAME"));
		return ambulance;
	}
 
}