package com.spring.dao.ambulance;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.AmbulanceCounts;

@Repository
public class AmbulanceCountsDAOImpl implements AmbulanceCountsDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public AmbulanceCounts getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmbulanceCounts update(AmbulanceCounts ambulancecounts) {
		int noOfAmbulances;
		System.out.println("INSIDE");
		 Statement stmt = null;
		String selectStmt = "SELECT NUMBEROFAMBULANCES FROM AMBULANCECOUNTS WHERE PROVIDERID = ? AND AMBULANCETYPE=?";
		String insertStmt = "INSERT INTO AMBULANCECOUNTS VALUES(?,?,?) ";
		Object[] params = new Object[] { ambulancecounts.getProviderId(),
				ambulancecounts.getAmbulanceType() };
		int[] types = new int[] { Types.NUMERIC,Types.VARCHAR,Types.NUMERIC };
		try {
			noOfAmbulances = (Integer) jdbcTemplate.queryForObject(selectStmt,
					params, Integer.class);
			
		} catch (EmptyResultDataAccessException e) {
			
			Object[] params_a= new Object[] { ambulancecounts.getProviderId(),
					ambulancecounts.getAmbulanceType(),ambulancecounts.getNumberOfAmbulance() };
			//System.out.println((String[])params_a);
			jdbcTemplate.update(insertStmt, params_a, types);
			return ambulancecounts;
		}
		// SQL statement to update the no of count if
		String updateStatement = "UPDATE AMBULANCECOUNTS SET NUMBEROFAMBULANCES ="+ambulancecounts.getNumberOfAmbulance()+"WHERE PROVIDERID="+ambulancecounts.getProviderId()+" AND AMBULANCETYPE ='"+ambulancecounts.getAmbulanceType()+"'";
		System.out.println(updateStatement);
		System.out.println(ambulancecounts.toString());
		try{
		Connection con = jdbcTemplate.getDataSource().getConnection();
		stmt = con.createStatement();
		stmt.executeUpdate(updateStatement);
		//int j = jdbcTemplate.update(updateStatement, new Object[] {ambulancecounts.getNumberOfAmbulance(),ambulancecounts.getProviderId(),ambulancecounts.getAmbulanceType()});
		//jdbcTemplate.
		System.out.println("j"+"jkj");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("jkjkj");
		return ambulancecounts;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AmbulanceCounts> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(AmbulanceCounts ambulanceCount) {
		// TODO Auto-generated method stub
		
	}

}
