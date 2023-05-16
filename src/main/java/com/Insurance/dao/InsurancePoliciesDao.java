package com.Insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Insurance.dto.InsurancePolicies;
import com.Insurance.repo.InsurancePoliciesRepo;

@Repository
public class InsurancePoliciesDao {

	@Autowired
	private InsurancePoliciesRepo repo;

	public InsurancePolicies saveInsureancePolicies(InsurancePolicies insurancePolicies) {
		return repo.save(insurancePolicies);
	}

	public InsurancePolicies updateInsurancePolicies(InsurancePolicies insurancePolicies, int id) {

		Optional<InsurancePolicies> insurancePolicies2 = repo.findById(id);

		if (insurancePolicies2.isPresent()) {
			insurancePolicies.setId(id);
			repo.save(insurancePolicies);
			return insurancePolicies2.get();
		} else {
			return null;
		}
	}

	public InsurancePolicies deleteInsurancePolicies(int id) {
		Optional<InsurancePolicies> insurancePolicies = repo.findById(id);
		if (insurancePolicies.isPresent()) {
			repo.deleteById(id);
			return insurancePolicies.get();
		} else {
			return null;
		}

	}

	public List<InsurancePolicies> getAllInsurancePolicies() {
		List<InsurancePolicies> insurancePolicies = repo.findAll();
		if (insurancePolicies.isEmpty()) {
			return null;
		} else {
			return insurancePolicies;
		}
	}

	public InsurancePolicies getInsuranceById(Integer id) {
		Optional<InsurancePolicies> insurancePolicies = repo.findById(id);

		if (insurancePolicies.isPresent()) {
			return insurancePolicies.get();
		} else {
			return null;
		}
	}

}
