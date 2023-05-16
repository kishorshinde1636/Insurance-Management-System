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
import com.Insurance.dto.InsurancePolicies;
import com.Insurance.service.InsurancePoliciesService;

@RestController
public class InsurancePoliciesController {

	@Autowired
	private InsurancePoliciesService service;

	@PostMapping("/saveInsurance")
	public ResponseEntity<ResponseStructure<InsurancePolicies>> saveInsurancePolicies(
			@RequestBody InsurancePolicies insurancePolicies) {
		return service.saveInsurancePolicies(insurancePolicies);

	}

	@PutMapping("/updateInsurancePolicies")
	public ResponseEntity<ResponseStructure<InsurancePolicies>> updateInsurancePolicies(
			@RequestBody InsurancePolicies insurancePolicies, @RequestParam int id) {
		return service.updateInsurancePolicies(insurancePolicies, id);
	}

	@GetMapping("/getInsuranceByID")
	public ResponseEntity<ResponseStructure<InsurancePolicies>> getInsuranceByID(@RequestParam Integer id) {
		return service.getInsuranceById(id);
	}

	@GetMapping("/getAllInsurancePolicies")
	public ResponseEntity<ResponseStructure<InsurancePolicies>> getAllInsurancePolicies() {
		return service.getAllInsurancePolicies();
	}

	@DeleteMapping("/deleteInsurancePolicies")
	public ResponseEntity<ResponseStructure<InsurancePolicies>> deleteInsurancePolicies(
			@RequestParam Integer insuranceId) {

		return service.deleteInsurancePolicies(insuranceId);
	}

}
