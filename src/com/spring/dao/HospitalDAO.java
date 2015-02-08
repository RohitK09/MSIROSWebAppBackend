package com.spring.dao;

import java.util.List;

import com.spring.model.Hospital;

public interface HospitalDAO {
	//Create
    public void save(Hospital hospital);
    //Read
    public Hospital getById(String hospitalId);
    //Update
    public void update(Hospital hospital);
    //Delete
    public void deleteById(int id);
    //Get All
    public List<Hospital> getAll();

}
