package com.db.log;

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
	//save a new log new line in Log Db
	public void save(MSIROSDbLog dblog) {
			//jdbcTemplate.e
		
	}
	@Override
	public List<MSIROSDbLog> getLogs() {
		// TODO Auto-generated method stub
		return null;
	}

}
