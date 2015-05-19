package com.spring.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spring.model.Ambulance;
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
		Object[] params = new Object[] { log.getMessage(), log.getLogLevel(),
				log.getDated() };
		// define SQL types of the arguments
		// int[] types = new int[] { Types.VARCHAR, Types.VARCHAR,
		// Types.NUMERIC,
		// Types.NUMERIC };
		jdbcTemplate.update(insertSql, params);

	}

	@Override
	public void update(MSIROSDbLog log) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MSIROSDbLog> getAll() {

		List<MSIROSDbLog> msirosLogList = new ArrayList<MSIROSDbLog>();
		String sql = "SELECT AUDITTYPE, CHANGED_TIME, TABLEAUDITED, CHANGEDBY FROM (SELECT RANK() OVER (ORDER BY CHANGED_TIME DESC)  Ranks, AUDITTYPE, CHANGED_TIME, TABLEAUDITED, CHANGEDBY FROM VICMAAUDIT) A WHERE Ranks <= 10 ORDER BY CHANGED_TIME DESC";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			MSIROSDbLog log = new MSIROSDbLog();
			if (row.get("TABLEAUDITED").toString()
					.equals("victim_transport_vehicle")) {
				if (row.get("AUDITTYPE").toString().trim()
						.equalsIgnoreCase("Update")) {

					log.setMessage("Victim Transport Vehicle en route ");
				}
				else{
				log.setMessage("Victim Transport Vehicle Checked In ");}
			} else if (row.get("TABLEAUDITED").toString()
					.equals("transportdecision")) {
				System.out.println(row.get("AUDITTYPE").toString().trim());
				log.setMessage("Victim assigned to Victim Transport Vehicle");
			} else if (row.get("TABLEAUDITED").toString().equals("victim"))
			{
				if (row.get("AUDITTYPE").toString().trim()
						.equalsIgnoreCase("Update")) {
					log.setMessage("Victim en route");
				} else {
					log.setMessage("Victim Triaged");
				}
			}

			log.setDated((Timestamp) row.get("CHANGED_TIME"));
			msirosLogList.add(log);
		}
		return msirosLogList;
	}

}
