package com.Insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Insurance.config.ResponseStructure;
import com.Insurance.dao.InsurancePoliciesDao;
import com.Insurance.dto.InsurancePolicies;
import com.Insurance.exception.InsurancePoliciesNotFoundByIdException;

@Service
public class InsurancePoliciesService {

	@Autowired
	private InsurancePoliciesDao dao;

	public ResponseEntity<ResponseStructure<InsurancePolicies>> saveInsurancePolicies(
			InsurancePolicies insurancePolicies) {

		ResponseStructure<InsurancePolicies> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("save InsurancePolicies");
		responseStructure.setData(dao.saveInsureancePolicies(insurancePolicies));

		return new ResponseEntity<ResponseStructure<InsurancePolicies>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<InsurancePolicies>> updateInsurancePolicies(
			InsurancePolicies insurancePolicies, int id) {

		InsurancePolicies insurancePolicies2 = dao.updateInsurancePolicies(insurancePolicies, id);
		ResponseStructure<InsurancePolicies> responseStructure = new ResponseStructure<>();

		if (insurancePolicies2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("save InsurancePolicies");
			responseStructure.setData(dao.saveInsureancePolicies(insurancePolicies));

			return new ResponseEntity<ResponseStructure<InsurancePolicies>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InsurancePoliciesNotFoundByIdException("Failed to Find");
		}

	}

	public ResponseEntity<ResponseStructure<InsurancePolicies>> deleteInsurancePolicies(int id) {
		InsurancePolicies insurancePolicies = dao.deleteInsurancePolicies(id);
		ResponseStructure<InsurancePolicies> responseStructure = new ResponseStructure<>();

		if (insurancePolicies != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("save InsurancePolicies");
			responseStructure.setData(insurancePolicies);

			return new ResponseEntity<ResponseStructure<InsurancePolicies>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InsurancePoliciesNotFoundByIdException("Failed to Find");
		}
	}

	public ResponseEntity<ResponseStructure<InsurancePolicies>> getInsuranceById(Integer id) {
		InsurancePolicies insurancePolicies = dao.getInsuranceById(id);
		ResponseStructure<InsurancePolicies> responseStructure = new ResponseStructure<>();

		if (insurancePolicies != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("save InsurancePolicies");
			responseStructure.setData(dao.saveInsureancePolicies(insurancePolicies));

			return new ResponseEntity<ResponseStructure<InsurancePolicies>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new InsurancePoliciesNotFoundByIdException("Failed to Find");
		}
	}

	public ResponseEntity<ResponseStructure<InsurancePolicies>> getAllInsurancePolicies() {

		ResponseStructure<InsurancePolicies> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("save InsurancePolicies");
		responseStructure.setData(dao.getAllInsurancePolicies());

		return new ResponseEntity<ResponseStructure<InsurancePolicies>>(responseStructure, HttpStatus.OK);

	}
}
