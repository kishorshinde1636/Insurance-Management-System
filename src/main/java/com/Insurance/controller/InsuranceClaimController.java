package com.Insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.config.ResponseStructure;
import com.Insurance.dto.InsuranceClaim;
import com.Insurance.service.InsuranceClaimService;

@RestController
public class InsuranceClaimController {
	@Autowired
	private InsuranceClaimService service;

	@PostMapping("/saveInsuranceClaim")
	public ResponseEntity<ResponseStructure<InsuranceClaim>> saveInsuranceClaim(@RequestBody InsuranceClaim claim) {
		return service.saveInsuranceClaim(claim);

	}

	@PutMapping("/updateInsuranceClaim")
	public ResponseEntity<ResponseStructure<InsuranceClaim>> updateInsuranceClaim(@RequestParam int id,
			@RequestBody InsuranceClaim claim) {
		return service.updateInsuranceClaim(id, claim);
	}

	@GetMapping("/getInsuranceClaimById")
	public ResponseEntity<ResponseStructure<InsuranceClaim>> getInsuranceClaimById(@RequestParam int id) {
		return service.getInsuranceClaimById(id);
	}

	@DeleteMapping("/deleteInsuranceClaimById")
	public ResponseEntity<ResponseStructure<InsuranceClaim>> deleteInsuranceClaimById(@RequestParam int id) {
		return service.deleteInsuranceClaimById(id);
	}

	@GetMapping("getAllInsuranceClaim")
	public ResponseEntity<ResponseStructure<InsuranceClaim>> getAllInsuranceClaim() {
		return service.getAllInsuranceClaim();
	}

}
