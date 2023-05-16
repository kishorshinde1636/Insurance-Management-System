package com.Insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Insurance.dto.InsuranceClaim;

public interface InsuranceClaimRepo extends JpaRepository<InsuranceClaim, Integer>{

}
