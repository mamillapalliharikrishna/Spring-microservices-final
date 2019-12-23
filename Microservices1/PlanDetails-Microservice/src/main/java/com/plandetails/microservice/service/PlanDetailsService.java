package com.plandetails.microservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plandetails.microservice.dto.PlanDetailsDTO;
import com.plandetails.microservice.entity.PlanDetails;
import com.plandetails.microservice.repository.PlanDetailsRepository;

@Service
public class PlanDetailsService {
	@Autowired
	private  PlanDetailsRepository  repo;
	
	public  List<PlanDetailsDTO>  getAllPlans() {
		List<PlanDetails>   list =repo.findAll();
		List<PlanDetailsDTO>  list2 = new  ArrayList<PlanDetailsDTO>();
		for(PlanDetails  p : list) {
			PlanDetailsDTO  dto = new  PlanDetailsDTO();
			/*dto.setPlanId(p.getPlanId());
			dto.setPlanName(p.getPlanName());
			dto.setTenure(p.getTenure());*/
			BeanUtils.copyProperties(p, dto);
			list2.add(dto);
		}
		return   list2;
	}
	
	public  PlanDetailsDTO  getSpecificPlan(Long  planId) {
		Optional<PlanDetails>  p = repo.findById(planId);
		PlanDetails  pp = p.get();
		PlanDetailsDTO  dto = new PlanDetailsDTO();
		/*dto.setPlanId(pp.getPlanId());
		dto.setPlanName(pp.getPlanName());
		dto.setTenure(pp.getTenure());*/
		BeanUtils.copyProperties(pp, dto);
		return  dto;
	}
}
