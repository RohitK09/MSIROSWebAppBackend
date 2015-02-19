package com.spring.rest.hospital;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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



// TODO: Auto-generated Javadoc
/**
 * The Class HospitalRestController.
 *
 * @author Rohit Katyal
 * @since 31st Decemeber 2014
 * @description :Controller for Hospital requests
 */
@ComponentScan
@RestController
@RequestMapping("/Hospital")
public class HospitalRestController {
	 final static Logger log = LoggerFactory.getLogger(HospitalRestController.class);

	  
		/** The Json data. */
		String JsonData ;
		
		/** The Hospital dao. */
		@Autowired
		private HospitalDAO HospitalDAO;


	
		/**
		 * Gets the hospital providers.
		 *
		 * @param model the model
		 * @param hospitalId the hospital id
		 * @return the hospital providers
		 */
		@Cacheable
		@RequestMapping(value = "/{hospitalId}" , method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String getHospitalProviders(ModelMap model,
				@PathVariable("hospitalId") String hospitalId) {
			 
			String jsonData = "Not A User" ;
			Hospital hospital = HospitalDAO.getById(hospitalId);
			ObjectMapper objmapper = new ObjectMapper();
			try {
				 
				 jsonData = objmapper.writeValueAsString(hospital);
				 //System.out.println(objmapper.writeValueAsString(hospital));
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return jsonData;
		}
		
		/**
		 * Sets the hospital providers.
		 *
		 * @param model the model
		 * @param Id the id
		 * @param numberOfBeds the number of beds
		 * @return the string
		 */
		@RequestMapping(value = "/update" , method = RequestMethod.POST)
		public @ResponseBody String setHospitalProviders(ModelMap model,
				@RequestParam("HospitalId") String Id,@RequestParam("numberOfBeds") String numberOfBeds ) {
			
			System.out.println(Id);
			Hospital hospital = HospitalDAO.getById(Id);
			hospital.setNumberOfBeds(Integer.parseInt(numberOfBeds));
			HospitalDAO.update(hospital);
			log.info("Upadating Hospital Beds Update:numberOfBeds"+numberOfBeds);
			return "Success";
			
		}
	}

