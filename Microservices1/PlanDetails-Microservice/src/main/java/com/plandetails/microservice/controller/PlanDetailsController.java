package com.plandetails.microservice.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.plandetails.microservice.dto.PlanDetailsDTO;
import com.plandetails.microservice.service.PlanDetailsService;


@RestController
public class PlanDetailsController {
	private  static  Logger  LOG=Logger.getLogger(PlanDetailsController.class);
	@Autowired
	private  PlanDetailsService  service;
	
	@GetMapping(value="/allPlans", produces="application/json")
	public  List<PlanDetailsDTO>   getAllPlans() {
		return   service.getAllPlans();
	}
	
	@GetMapping(value="/{planId}",  produces="application/json")
	public  PlanDetailsDTO   getSpecificPlan(@PathVariable Long  planId) {
		LOG.log(Level.INFO, "getSpecificPlan  called...");
		return  service.getSpecificPlan(planId);
	}
}
