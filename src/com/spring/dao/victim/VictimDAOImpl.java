package com.spring.dao.victim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.AmbulanceType;
import com.spring.model.Victim;
import com.spring.model.VictimStatus;

@Repository
public class VictimDAOImpl implements VictimDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void save(Victim victim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Victim getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Victim ambulance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Victim> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	//GETS COUNT OF VICTIMS DEPENDING ON Type
	@Override
	public ArrayList<VictimStatus> getCountByType() {
		String sql = "Select STATUSID ,count(*) AS COUNT from Victimstatus group by STATUSID";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		ArrayList<VictimStatus> mapOfType = new ArrayList<VictimStatus>();
		for (Map row : rows) {
			VictimStatus victype = new VictimStatus();
			victype.setSTATUSID(Integer.parseInt(row.get("STATUSID").toString()));
			victype.setVICTIMID(Integer.parseInt(row.get("COUNT").toString()));
			//victype.setDECISIONDATETIME(dECISIONDATETIME);
			mapOfType.add(victype);
		}
		return mapOfType;
	}
}

