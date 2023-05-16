package com.Insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Insurance.dto.InsuranceClaim;
import com.Insurance.repo.InsuranceClaimRepo;

@Repository
public class InsuranceClaimDao {

	@Autowired
	private InsuranceClaimRepo claimRepo;

	public InsuranceClaim saveInsuranceClaim(InsuranceClaim claim) {

		return claimRepo.save(claim);
	}

	public InsuranceClaim updateInsuranceClaim(int id, InsuranceClaim claim) {

		Optional<InsuranceClaim> claim2 = claimRepo.findById(id);
		if (claim2.isPresent()) {
			claim.setId(id);
			claimRepo.save(claim);
			return claim2.get();
		} else {
			return null;
		}
	}

	public InsuranceClaim getInsuranceClaimById(int id) {

		Optional<InsuranceClaim> claim = claimRepo.findById(id);

		if (claim.isEmpty()) {
			return null;
		} else {
			return claim.get();
		}
	}

	public InsuranceClaim deleteInsuranceClaimById(int id) {

		Optional<InsuranceClaim> claim = claimRepo.findById(id);

		if (claim.isPresent()) {
			claimRepo.deleteById(id);
			return claim.get();
		} else {
			return null;
		}
	}

	public List<InsuranceClaim> getAllInsuranceClaim() {

		return claimRepo.findAll();

	}

}
