package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.AmbulanceProvider;
import com.spring.model.Hospital;
@Repository
public class AmbulanceProviderDAOImpl implements AmbulanceProviderDAO{
	private JdbcTemplate jdbcTemplate;
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public void save(AmbulanceProvider ambulance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AmbulanceProvider getById(int id) {
		System.out.println("Id"+id);
		String sql = "SELECT * FROM AMBULANCEPROVIDER WHERE PROVIDERID = ?";
		AmbulanceProvider provider = (AmbulanceProvider) jdbcTemplate.queryForObject(sql,new Object[] { id }, new AmbulanceProviderRowMapper());
		System.out.println(provider.getProviderName());
		return provider;
		
	}

	@Override
	public void update(AmbulanceProvider ambulance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AmbulanceProvider> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
