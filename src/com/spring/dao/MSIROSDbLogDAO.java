package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import com.spring.model.MSIROSDbLog;
import com.spring.model.Victim;
import com.spring.model.VictimCount;
import com.spring.model.VictimStatus;

public interface MSIROSDbLogDAO {
	 
	     
	    //Create
	    public void save(MSIROSDbLog log);
	    //Update
	    public void update(MSIROSDbLog log);
	    //Get All Logs
	    public List<MSIROSDbLog> getAll();
	  
	   
	    
	}
