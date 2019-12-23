package com.customer.microservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.microservice.dto.PlanDetailsDTO;

@FeignClient("PLANDETAILS")
public interface CustPlanFeign {
	@RequestMapping("/PlanDetailsMicroservice/{planId}")
	PlanDetailsDTO    getSpecificPlan(@PathVariable("planId")Long  planId);
}
