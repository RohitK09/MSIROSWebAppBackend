package com.db.log;

import java.util.List;

import com.spring.model.MSIROSDbLog;

public interface MSIROSDbLogDAO {
public void save(MSIROSDbLog dblog);
public List<MSIROSDbLog> getLogs();

}