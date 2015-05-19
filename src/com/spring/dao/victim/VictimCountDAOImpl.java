package com.spring.dao.victim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.VictimCount;
import com.spring.model.VictimStatus;
@Repository
public class VictimCountDAOImpl implements VictimCountDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void save(VictimCount victim) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VictimCount getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(VictimCount victimcount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VictimCount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VictimCount> getCountByType() {
		//old sql for UB AOS Query
		//String sql = "SELECT  COUNT(*) TotalCount, a.STATUS ,a.STATUSID FROM    STATUS a INNER JOIN VICTIMSTATUS b ON a.STATUSID = b.STATUSID GROUP   BY a.STATUSID, a.STATUS";
		//COUNT of Victims at Staging Location. 
		String sql = "SELECT  COUNT(*) TotalCount,STATUS  From VICTIM  where IN_STAGING_AREA = 1 GROUP BY STATUS ";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		ArrayList<VictimCount> mapOfType = new ArrayList<VictimCount>();
		for (Map row : rows) {
			VictimCount victype = new VictimCount();
			victype.setStatusDesc(row.get("STATUS").toString());
			victype.setCount(Integer.parseInt(row.get("TotalCount").toString()));
			//victype.setStatusId(Integer.parseInt(row.get("STATUSID").toString()));
			//victype.setDECISIONDATETIME(dECISIONDATETIME);
			mapOfType.add(victype);
			
		}
		return mapOfType;
	}
	

}
