package com.spring.dao.incident;

import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




import com.spring.model.Incident;
@Repository
public class IncidentDAOImpl implements IncidentDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Incident incident) {
		String insertSql = "INSERT INTO INCIDENT (INCIDENTID, INCIDENTDATE, LONGITUDE, LATITUDE, LOCATIONNAME) VALUES (seq_incidentId.nextval, TO_TIMESTAMP(?, 'DD-MM-YYYY hh:mi:ss'), ?, ?, ?)";
		// define query arguments
		Object[] params = new Object[]{incident.getINCIDENTDATE(),incident.getLONGITUDE(),incident.getLATITUDE(),incident.getLOCATIONNAME()};
		// define SQL types of the arguments
		//int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.NUMERIC,
		//	Types.NUMERIC };
		jdbcTemplate.update(insertSql, params);
	}

	@Override
	public Incident getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Incident update(Incident incident) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Incident> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
