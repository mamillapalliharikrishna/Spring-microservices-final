package com.plandetails.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plan_details")
public class PlanDetails {
	@Id
	@Column(name="plan_id")
	private  Long  planId;
	
	@Column(name="plan_name")
	private  String  planName;
	
	@Column(name="tenure")
	private  String  tenure;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	
	
	

}
