package com.customer.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.microservice.dto.PlanDetailsDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@Service

public class CustomerCircuitBreaker {
	String    FRIEND_URL="http://FRIEND/FriendMicroservice/friends/{phoneNo}";
	String   PLAN_URL="http://PLANDETAILS/PlanDetailsMicroservice/{planId}";
	/*@Autowired
	RestTemplate   restTemplate;*/
	
	@Autowired
	CustFriendFeign   friendFeign;
	
	@Autowired
	CustPlanFeign  feign;
	
	@HystrixCommand(fallbackMethod="getFriendsCallback")
	public   List<Long>   getFriends(Long  phoneNo) {
		System.out.println("getFriends()");
		//ResponseEntity<List<Long>>    friends=restTemplate.exchange(FRIEND_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Long>>() { }, phoneNo);
		ResponseEntity<List<Long>>    friends=friendFeign.getFriendsList(phoneNo);
		List<Long>  friendsList=friends.getBody();
		return  friendsList;
		
	}
	
	public   List<Long>    getFriendsCallback(Long  phoneNo) {
		System.out.println("getFriendsCallback()");
		return   new   ArrayList<Long>();
	}
	
	/*public   Future<PlanDetailsDTO>   getSpecificPlan(Long planId) {
		return   new  AsyncResult<PlanDetailsDTO>() {
			public PlanDetailsDTO   invoke() {
				//return  restTemplate.getForObject(PLAN_URL, PlanDetailsDTO.class, planId);
				return   feign.getSpecificPlan(planId);
			}
			
		};

	}*/

public PlanDetailsDTO   invoke(Long planId) {
	//return  restTemplate.getForObject(PLAN_URL, PlanDetailsDTO.class, planId);
	return   feign.getSpecificPlan(planId);
}
		
}
