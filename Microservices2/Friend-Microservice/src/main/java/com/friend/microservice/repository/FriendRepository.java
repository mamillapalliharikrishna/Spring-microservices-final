package com.friend.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.friend.microservice.entity.Friend;

@Repository
public interface FriendRepository  extends  JpaRepository<Friend,Integer> {
	List<Friend>   findByPhoneNo(Long  phoneNo);

}
