package com.spring.rest.incident;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.incident.IncidentDAO;
import com.spring.dao.incident.IncidentDAOImpl;
import com.spring.model.Hospital;
import com.spring.model.Incident;

@ComponentScan
@RequestMapping("/incident")
@RestController
public class IncidentRestController {

	@Autowired
	private IncidentDAO incidentDAO;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody String newIncident(
			@RequestParam("locationTxt") String locationName,
			@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude,
			@RequestParam("dateTxt") String date) {
		// incident.getINCIDENTDATE();
		Incident incident = new Incident();
		//System.out.println(Timestamp.valueOf(date));
		incident.setINCIDENTDATE(date);
		incident.setLATITUDE(Double.valueOf(latitude));
		incident.setLONGITUDE(Double.valueOf(longitude));
		incident.setLOCATIONNAME(locationName);
		incidentDAO.save(incident);
		return "Success";
	}

}
