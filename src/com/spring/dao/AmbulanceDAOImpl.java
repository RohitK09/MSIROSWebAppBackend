package com.spring.dao;

import java.io.StringWriter;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.spring.model.Ambulance;
import com.spring.model.AmbulanceType;

@Repository
public class AmbulanceDAOImpl implements AmbulanceDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Ambulance ambulance) {

		String selectSql;
		int providerId = 0;

		try {
			selectSql = "SELECT PROVIDERID FROM AMBULANCEPROVIDER WHERE PROVIDERNAME = ?";
			providerId = (Integer) jdbcTemplate.queryForObject(selectSql,
					new Object[] { ambulance.getAmbulanceProviderName() },
					Integer.class);
		} catch (EmptyResultDataAccessException e) {

			return;
		}
		ambulance.setAmbulanceProviderID(providerId);
		// System.out.println(jdbcTemplate.getDataSource());
		String insertSql = "insert into Ambulance Values(seq_ambulanceId.nextval,?,?,?,?)";
		// define query arguments
		Object[] params = new Object[] { ambulance.getAmbulanceType(),
				ambulance.getAmbulanceType(), ambulance.getIsAvailable(),
				ambulance.getAmbulanceProviderID() };

		// define SQL types of the arguments

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.NUMERIC,
				Types.NUMERIC };
		jdbcTemplate.update(insertSql, params, types);
		// ambulance = (Ambulance)jdbcTemplate.queryForObject(sql,new Object[] {
		// id }, new AmbulanceRowMapper());

	}

	@Override
	public Ambulance getById(int id) {
		// TODO Auto-generated method stub
		Ambulance ambulance = new Ambulance();
		/*
		 * JdbcTemplate jdbcTemplate = new JdbcTemplate();
		 * System.out.println(dataSource);
		 * jdbcTemplate.setDataSource(dataSource);
		 */
		System.out.println(jdbcTemplate.getDataSource());
		String sql = "SELECT * FROM AMBULANCE WHERE AMBULANCEID = ?";
		ambulance = (Ambulance) jdbcTemplate.queryForObject(sql,
				new Object[] { id }, new AmbulanceRowMapper());

		return ambulance;
	}

	@Override
	public void update(Ambulance ambulance) {

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ambulance> getAll() {
		List<Ambulance> ambulanceList = new ArrayList<Ambulance>();
		String sql = "SELECT * FROM ACTIVEAMBULANCES";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Ambulance ambulance = new Ambulance();
			ambulance.setID((String) row.get("AMBULANCEID").toString());
			ambulance.setAmbulanceType((String) row.get("AMBULANCETYPE"));
			ambulance.setVehicleNumber((String) row.get("VEHICLENO"));
			ambulance.setAmbulanceProviderName((String) row
					.get("AMBULANCEPROVIDERNAME").toString().trim());
			ambulanceList.add(ambulance);
		}
		return ambulanceList;
	}

	@Override
	public List<Ambulance> getAmbulancesByProviderName(String provider) {
		List<Ambulance> ambulanceList = new ArrayList<Ambulance>();
		String sql = "SELECT * FROM AMBULANCE WHERE PROVIDERID='" + provider
				+ "'and ISAVAILABLE = 0";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Ambulance ambulance = new Ambulance();
			ambulance.setID((String) row.get("AMBULANCEID").toString());
			ambulance.setAmbulanceType((String) row.get("AMBULANCETYPE"));
			ambulance.setVehicleNumber((String) row.get("VEHICLENO"));
			ambulance.setAmbulanceProviderName((String) row
					.get("AMBULANCEPROVIDERNAME"));
			ambulanceList.add(ambulance);
		}
		return ambulanceList;
	}

	@Override
	public ArrayList<AmbulanceType> getCountOfAmbulances() {
		String sql = "SELECT Count(*) AS AmbulanceCounts,AmbulanceType FROM Ambulance WHERE (IsAvailable=0) GROUP BY AmbulanceType";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		ArrayList<AmbulanceType> mapOfType = new ArrayList<AmbulanceType>();
		for (Map row : rows) {
			AmbulanceType ambType = new AmbulanceType();
			ambType.setAmbulanceType(row.get("AmbulanceType").toString());
			ambType.setCount(Integer.valueOf(row.get("AmbulanceCounts")
					.toString()));
			mapOfType.add(ambType);
		}
		return mapOfType;
	}

}
