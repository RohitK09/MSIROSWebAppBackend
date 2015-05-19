package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.SQLError;
import com.spring.model.Hospital;

@Repository
public class HospitalDAOImpl implements HospitalDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Hospital hospital) {
		// TODO Auto-generated method stub

	}

	@Override
	public Hospital getById(String id) throws Exception {

		String sql = "SELECT * FROM HOSPITAL WHERE HOSPITAL_ID = ?";
		System.out.println(id);
		Hospital hospital = (Hospital) jdbcTemplate.queryForObject(sql,new Object[] { id }, new HospitalRowMapper());
		
		return hospital;
	}

	@Override
	public void update(Hospital hospital) {
		// TODO Auto-generated method stub
		// String updateStatement =
		// " UPDATE HOSPITAL SET BEDS_AVAILABLE =? WHERE HOSPITALID=?";
		String updateStatement = "UPDATE HOSPITAL SET BEDS_AVAILABLE =? WHERE HOSPITAL_ID=?";
		jdbcTemplate.update(
				updateStatement,
				new Object[] { hospital.getNumberOfBeds(),
						hospital.getHospitalId() });
		// System.out.println(updateStatement);

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Hospital> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
