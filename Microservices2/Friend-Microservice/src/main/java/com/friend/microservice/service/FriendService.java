package com.friend.microservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friend.microservice.entity.Friend;
import com.friend.microservice.repository.FriendRepository;

@Service
public class FriendService {
	@Autowired
	private  FriendRepository  repo;
	
	public boolean  addFriend(Friend  friend) {
		boolean  flag=repo.existsById(friend.getId());
		if(flag==true) {
			return false;
		}
		else {
			repo.save(friend);
			return true;
		}
		
	}
	
	
	public  List<Long>  getFriends(Long phoneNo) {
		List<Friend>  list = repo.findByPhoneNo(phoneNo);
		List<Long>   list2 = new  ArrayList<Long>();
		for(Friend  f:  list) {
			list2.add(f.getFriendNo());
		}
		return  list2;
	}
}
