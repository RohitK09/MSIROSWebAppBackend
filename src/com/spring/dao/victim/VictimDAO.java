package com.spring.dao.victim;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spring.model.AmbulanceType;
import com.spring.model.Victim;
import com.spring.model.VictimStatus;

 
//CRUD operations
public interface VictimDAO {
     
    //Create
    public void save(Victim victim);
    //Read
    public Victim getById(int id);
    //Update
    public void update(Victim ambulance);
    //Delete
    public void deleteById(int id);
    //Get All
    public List<Victim> getAll();
   
    /*
     * @Author:Rohit Katyal
     * @param: none
     * @Date:30 th Jan 2015
     * @Description: Get All Count By Status
     */
    public ArrayList<VictimStatus> getCountByType();
   
    
}
