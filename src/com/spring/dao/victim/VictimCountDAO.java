package com.spring.dao.victim;

import java.util.ArrayList;
import java.util.List;

import com.spring.model.Victim;
import com.spring.model.VictimCount;
import com.spring.model.VictimStatus;

public interface VictimCountDAO {
	 
	     
	    //Create
	    public void save(VictimCount victim);
	    //Read
	    public VictimCount getById(int id);
	    //Update
	    public void update(VictimCount victimcount);
	    //Delete
	    public void deleteById(int id);
	    //Get All
	    public List<VictimCount> getAll();
	   
	    /*
	     * @Author:Rohit Katyal
	     * @param: none
	     * @Date:30 th Jan 2015
	     * @Description: Get All Count By Status
	     */
	    public ArrayList<VictimCount> getCountByType();
	   
	    
	}




