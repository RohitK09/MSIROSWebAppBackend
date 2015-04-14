package com.spring.dao;

import java.util.List;

import com.spring.model.MSIROSDbLog;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MSIROSDbLogDAOImpl implements MSIROSDbLogDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(MSIROSDbLog log) {
		
		String insertSql = "INSERT INTO LOGS (LOGID,MESSAGE,LOGLEVEL,DATED) VALUES (seq_logID.nextval,?,?,?)";
		// define query arguments
		Object[] params = new Object[]{log.getMessage(),log.getLogLevel(),log.getDated()};
		// define SQL types of the arguments
		//int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.NUMERIC,
		//	Types.NUMERIC };
		jdbcTemplate.update(insertSql, params);
		
	}
	

	@Override
	public void update(MSIROSDbLog log) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MSIROSDbLog> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
