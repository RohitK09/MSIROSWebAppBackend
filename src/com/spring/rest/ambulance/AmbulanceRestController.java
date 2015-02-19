package com.spring.rest.ambulance;

import java.io.IOException;







import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


















import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.dao.AmbulanceDAO;
import com.spring.dao.AmbulanceDAOImpl;
import com.spring.dao.AmbulanceProviderDAO;
import com.spring.dao.ambulance.AmbulanceCountsDAO;
import com.spring.model.Ambulance;
import com.spring.model.AmbulanceCounts;
import com.spring.model.AmbulanceProvider;
import com.spring.model.AmbulanceType;

@ComponentScan
@RestController
@RequestMapping("/Ambulance")
public class AmbulanceRestController {
	String JsonData ;
	@Autowired
	private AmbulanceCountsDAO ambDAO ;
	@Autowired
	private AmbulanceDAO ambulanceDAO;
	@Autowired
	private AmbulanceProviderDAO ambulanceProviderDAO;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String getAllUsers(ModelMap model) {
		String jsonData = "[{\"id\":\"3253123\",\"firstname\":\"Chris\",\"lastname\":\"Johnson\",\"address\":\"211, Geoffrey Drive\",\"city\":\"Newark\",\"phone\":\"999-888-6666\",\"email\":\"chrisj@yahoo.com\"},{\"id\":\"67643837\",\"firstname\":\"Bill\",\"lastname\":\"Derkson\",\"address\":\"201, Sleepy Hollow Drive\",\"city\":\"Newark\",\"phone\":\"999-777-2222\",\"email\":\"billd@gmail.com\"}]";
		return jsonData;
	}
	@RequestMapping(value = "do/AmbulanceTypeUpdate" , method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String AmbulanceTypeCountUpdate(ModelMap model,
			@RequestParam("AmbulanceProviderId") int  AmbulanceProviderId,@RequestParam("Basic") String basic ,@RequestParam("Intermediate") String intermediate ,@RequestParam("AdvancedCare") String advancedcare ) {
		
		String jsonData = "Not A User" ;
		System.out.println("inside");
		AmbulanceCounts ambulanceCounts = new AmbulanceCounts();
		ambulanceCounts.setProviderId(AmbulanceProviderId);
		System.out.println("))))"+AmbulanceProviderId);
		System.out.println(basic);
		if(basic!=null)
		{
			ambulanceCounts.setNumberOfAmbulance(Integer.valueOf(basic));
			ambulanceCounts.setAmbulanceType("Type I");
			ambDAO.update(ambulanceCounts);
			
			
		}
		if(intermediate!=null)
		{
			ambulanceCounts.setAmbulanceType("Type II");
			ambulanceCounts.setNumberOfAmbulance(Integer.valueOf(intermediate));
			ambDAO.update(ambulanceCounts);
		}
		if(advancedcare!=null)
		{	
			ambulanceCounts.setAmbulanceType("Type III");
			ambulanceCounts.setNumberOfAmbulance(Integer.valueOf(advancedcare));
			ambDAO.update(ambulanceCounts);
		}
		
		
		
		return "Success";
		
}
	//check in the vehicles and update the number of vehicle and their types
		@RequestMapping(value = "do/vehicleCheckIn" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String vehicleCheckIn(ModelMap model,
				@RequestParam("ProviderName") String ProviderName,@RequestParam("vehicleType") String ambulanceType ,@RequestParam("vehicleNumber") String vehicleNumber  ) {
			
			String jsonData = "Not A User" ;
			System.out.println("inside");
			try {
				
			Ambulance ambulance = new Ambulance();
			ambulance.setAmbulanceProviderName(ProviderName);
			ambulance.setAmbulanceType(ambulanceType);
			ambulance.setIsAvailable(0);
			ambulance.setVehicleNumber(vehicleNumber);
			ambulanceDAO.save(ambulance);
			
			return new ObjectMapper().writeValueAsString(ambulance);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//failure 
			return "-1";
	}
	
	/**
	 * Gets the ambulance providers.
	 *
	 * @param model 
	 * @param ProviderName the provider name
	 * @return the ambulance provider
	 */
	@RequestMapping(value = "/{providername}" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAmbulanceProviders(ModelMap model,
			@PathVariable("providername") String ProviderName) {
		String jsonData = "Not A User" ;
		System.out.println("inside");
		List<Ambulance> ambulance = ambulanceDAO.getAmbulancesByProviderName(ProviderName);
		ObjectMapper objmapper = new ObjectMapper();
		try {
			 jsonData = objmapper.writeValueAsString(ambulance);
			System.out.println(objmapper.writeValueAsString(ambulance));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonData;
	}
	@RequestMapping(value = "/update" , method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String setAmbulanceProviders(ModelMap model,
			@PathVariable("id") int Id ) {
		String jsonData = "Not A User" ;
		System.out.println("inside");
		Ambulance ambulance = ambulanceDAO.getById(Id);

		ObjectMapper objmapper = new ObjectMapper();
		try {
			 jsonData = objmapper.writeValueAsString(ambulance);
			System.out.println(objmapper.writeValueAsString(ambulance));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonData;
	}
	@RequestMapping(value = "/getAllProviders" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAll(ModelMap model) {
		String jsonData = "Not A User" ;
		System.out.println("inside");
		List<Ambulance> ambulances = ambulanceDAO.getAll();
		ObjectMapper objmapper = new ObjectMapper();
		try {
			 jsonData = objmapper.writeValueAsString(ambulances);
			//System.out.println(objmapper.writeValueAsString(ambulance));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonData;
	}
	@RequestMapping(value = "/getAllTypesOfAmbulances" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllTypesOfAmbulance(ModelMap model) {
		String jsonData = "Not A User" ;
		System.out.println("inside");
		ArrayList<AmbulanceType> mapOfAllAmbulanceTypes = ambulanceDAO.getCountOfAmbulances();
		ObjectMapper objmapper = new ObjectMapper();
		try {
			 jsonData = objmapper.writeValueAsString(mapOfAllAmbulanceTypes);
			//System.out.println(objmapper.writeValueAsString(ambulance));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonData;
	}
	
	/*
	 * Get provider Name by provider Id
	 * @author : Rohit Katyal
	 * Added : 26th jan 2015
	 */
	@RequestMapping(value = "/getProviderName/{id}" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getProviderName(ModelMap model,@PathVariable("id") int Id ) {
		try 
		{
			AmbulanceProvider ambulanceProvider	 = ambulanceProviderDAO.getById(Id);
			JsonData = new ObjectMapper().writeValueAsString(ambulanceProvider);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return JsonData;
	
	}
	
}