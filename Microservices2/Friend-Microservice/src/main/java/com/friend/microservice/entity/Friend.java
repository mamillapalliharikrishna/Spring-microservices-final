package com.friend.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Friend")
public class Friend {
	@Id
	@Column(name="id")
	private  Integer  id;
	
	@Column(name="phone_no")
	private   Long  phoneNo;
	
	@Column(name="friend_no")
	private  Long  friendNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getFriendNo() {
		return friendNo;
	}

	public void setFriendNo(Long friendNo) {
		this.friendNo = friendNo;
	}
	
}
