package com.spring.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spring.model.Ambulance;
import com.spring.model.AmbulanceType;

 
//CRUD operations
public interface AmbulanceDAO {
     
    //Create
    public void save(Ambulance ambulance);
    //Read
    public Ambulance getById(int id);
    //Update
    public void update(Ambulance ambulance);
    //Delete
    public void deleteById(int id);
    //Get All
    public List<Ambulance> getAll();
    //Get by Provider Name
    public List<Ambulance>getAmbulancesByProviderName(String provider);
   // get Ambulance count by type
   public ArrayList<AmbulanceType> getCountOfAmbulances();
  
}
