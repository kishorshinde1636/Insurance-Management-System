package com.Insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Insurance.config.ResponseStructure;
import com.Insurance.dao.InsuranceClaimDao;
import com.Insurance.dto.InsuranceClaim;
import com.Insurance.exception.InsuranceClaimIdNotFoundException;

@Service
public class InsuranceClaimService {

	@Autowired
	private InsuranceClaimDao claimDao;

	public ResponseEntity<ResponseStructure<InsuranceClaim>> saveInsuranceClaim(InsuranceClaim claim) {

		ResponseStructure<InsuranceClaim> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("InsuranceClaim save");
		responseStructure.setData(claimDao.saveInsuranceClaim(claim));

		return new ResponseEntity<ResponseStructure<InsuranceClaim>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<InsuranceClaim>> updateInsuranceClaim(int id, InsuranceClaim claim) {

		InsuranceClaim claim2 = claimDao.updateInsuranceClaim(id, claim);
		ResponseStructure<InsuranceClaim> responseStructure = new ResponseStructure<>();

		if (claim2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage(" Update InsuranceClaim");
			responseStructure.setData(claimDao.saveInsuranceClaim(claim));
			return new ResponseEntity<ResponseStructure<InsuranceClaim>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InsuranceClaimIdNotFoundException("failed to find Id");
		}
	}

	public ResponseEntity<ResponseStructure<InsuranceClaim>> getInsuranceClaimById(int id) {

		InsuranceClaim claim = claimDao.getInsuranceClaimById(id);
		ResponseStructure<InsuranceClaim> responseStructure = new ResponseStructure<>();
		if (claim != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Get InsuranceClaim");
			responseStructure.setData(claimDao.saveInsuranceClaim(claim));
			return new ResponseEntity<ResponseStructure<InsuranceClaim>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new InsuranceClaimIdNotFoundException("failed to find Id");
		}
	}

	public ResponseEntity<ResponseStructure<InsuranceClaim>> deleteInsuranceClaimById(int id) {
		InsuranceClaim claim = claimDao.deleteInsuranceClaimById(id);
		ResponseStructure<InsuranceClaim> responseStructure = new ResponseStructure<>();

		if (claim != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Delete InsuranceClaim");
			responseStructure.setData(claimDao.saveInsuranceClaim(claim));
			return new ResponseEntity<ResponseStructure<InsuranceClaim>>(responseStructure, HttpStatus.OK);
		} else {
			throw new InsuranceClaimIdNotFoundException("failed to find Id");
		}
	}

	public ResponseEntity<ResponseStructure<InsuranceClaim>> getAllInsuranceClaim() {

		ResponseStructure<InsuranceClaim> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Get All InsuranceClaim Details");
		responseStructure.setData(claimDao.getAllInsuranceClaim());
		return new ResponseEntity<ResponseStructure<InsuranceClaim>>(responseStructure, HttpStatus.FOUND);

	}

}
