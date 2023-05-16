package com.Insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Insurance.dto.InsurancePolicies;

public interface InsurancePoliciesRepo extends JpaRepository<InsurancePolicies, Integer> {

}
