package com.plandetails.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plandetails.microservice.entity.PlanDetails;

@Repository
public interface PlanDetailsRepository extends  JpaRepository<PlanDetails,Long>{

}
