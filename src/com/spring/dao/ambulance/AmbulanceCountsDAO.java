package com.spring.dao.ambulance;

import java.util.List;

import com.spring.model.AmbulanceCounts;


public interface AmbulanceCountsDAO {
	 public void save(AmbulanceCounts ambulanceCount);
	    //Read
	    public AmbulanceCounts getById(int id);
	    //Update
	    public AmbulanceCounts update(AmbulanceCounts ambulance);
	    //Delete
	    public void deleteById(int id);
	    //Get All
	    public List<AmbulanceCounts> getAll();
}
