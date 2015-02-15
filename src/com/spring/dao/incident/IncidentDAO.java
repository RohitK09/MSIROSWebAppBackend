package com.spring.dao.incident;

import java.util.List;

import com.spring.model.Incident;

public interface  IncidentDAO {
	//Save
	public void save(Incident incident);
    //Read
    public Incident getById(int id);
    //Update
    public Incident update(Incident incident);
    //Delete
    public void deleteById(int id);
    //Get All
    public List<Incident> getAll();
}