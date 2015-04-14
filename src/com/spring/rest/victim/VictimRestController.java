package com.spring.rest.victim;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.dao.MSIROSDbLogDAO;
import com.spring.dao.victim.VictimCountDAO;
import com.spring.dao.victim.VictimDAO;
import com.spring.model.MSIROSDbLog;
import com.spring.model.VictimCount;
import com.spring.model.VictimStatus;
/*
 * Controller for Victim  
 */
@ComponentScan
@RestController
@RequestMapping("/Victim")
public class VictimRestController {

	String JsonData;
	@Autowired
	private VictimCountDAO VictimDAO;
	@Autowired
	private MSIROSDbLogDAO logDAO;
	private MSIROSDbLog log = new MSIROSDbLog();
	
	/*
	 * Get all victim and their count corresponding to their type
	 */
	@RequestMapping(value = "/getAllTypesOfVictims", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAllTypesOfAmbulance(ModelMap model) {
		String jsonData = "Not A User";
		System.out.println("inside");
		ArrayList<VictimCount> mapOfAllVictimTypes = VictimDAO.getCountByType();
		ObjectMapper objmapper = new ObjectMapper();
		try {
			jsonData = objmapper.writeValueAsString(mapOfAllVictimTypes);
			log.setLog("info", "Get Ambulance information" );
			logDAO.save(log);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonData;
	}

}
