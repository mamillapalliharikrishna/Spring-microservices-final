package com.customer.microservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("FRIEND")
public interface CustFriendFeign {
	@RequestMapping(value="/FriendMicroservice/friends/{phoneNo}")
	ResponseEntity<List<Long>>   getFriendsList(@PathVariable("phoneNo")	  Long  phoneNo);

}
