package com.spring.dao;
import java.util.List;



import com.spring.model.AmbulanceProvider;


 
//CRUD operations
public interface AmbulanceProviderDAO {
     
    //Create
    public void save(AmbulanceProvider ambulance);
    //Read
    public AmbulanceProvider getById(int id);
    //Update
    public void update(AmbulanceProvider ambulance);
    //Delete
    public void deleteById(int id);
    //Get All
    public List<AmbulanceProvider> getAll();
    //Get by Provider Name
    
  
  
}
