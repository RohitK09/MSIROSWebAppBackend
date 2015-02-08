package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	public Hospital getById(String id) {
		
		String sql = "SELECT * FROM HOSPITAL WHERE HOSPITALID = ?";
		System.out.println(id);
		Hospital hospital = (Hospital) jdbcTemplate.queryForObject(sql,new Object[] { id }, new HospitalRowMapper());
		//System.out.println(hospital.NumberOfBeds);
		return hospital;
	}

	@Override
	public void update(Hospital hospital) {
		// TODO Auto-generated method stub
		String updateStatement = " UPDATE HOSPITAL SET NUMBEROFBEDS =? WHERE HOSPITALID=?";
		jdbcTemplate.update(updateStatement, new Object[] {hospital.getNumberOfBeds(), hospital.getHospitalId()});
		System.out.println(updateStatement);
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
