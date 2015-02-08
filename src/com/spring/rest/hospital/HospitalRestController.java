package com.spring.rest.hospital;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.dao.HospitalDAO;
import com.spring.model.Hospital;

@ComponentScan
@RestController
@RequestMapping("/Hospital")
public class HospitalRestController {
	
		String JsonData ;
		@Autowired
		private HospitalDAO HospitalDAO;

		@RequestMapping(value = "/hello", method = RequestMethod.GET)
		public @ResponseBody String getAllUsers(ModelMap model) {
			String jsonData = "[{\"id\":\"3253123\",\"firstname\":\"Chris\",\"lastname\":\"Johnson\",\"address\":\"211, Geoffrey Drive\",\"city\":\"Newark\",\"phone\":\"999-888-6666\",\"email\":\"chrisj@yahoo.com\"},{\"id\":\"67643837\",\"firstname\":\"Bill\",\"lastname\":\"Derkson\",\"address\":\"201, Sleepy Hollow Drive\",\"city\":\"Newark\",\"phone\":\"999-777-2222\",\"email\":\"billd@gmail.com\"}]";
			return jsonData;
		}
		
		@RequestMapping(value = "/{hospitalId}" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String getHospitalProviders(ModelMap model,
				@PathVariable("hospitalId") String hospitalId) {
			String jsonData = "Not A User" ;
			System.out.println("inside");
			Hospital hospital = HospitalDAO.getById(hospitalId);
			ObjectMapper objmapper = new ObjectMapper();
			try {
				 jsonData = objmapper.writeValueAsString(hospital);
				 System.out.println(objmapper.writeValueAsString(hospital));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return jsonData;
		}
		@RequestMapping(value = "/update" , method = RequestMethod.POST)
		public @ResponseBody String setHospitalProviders(ModelMap model,
				@RequestParam("HospitalId") String Id,@RequestParam("numberOfBeds") String numberOfBeds ) {
			String jsonData = "Not A User" ;
			System.out.println(Id);
			Hospital hospital = HospitalDAO.getById(Id);
			hospital.setNumberOfBeds(Integer.parseInt(numberOfBeds));
			HospitalDAO.update(hospital);
			return "Success";
		}
	}

