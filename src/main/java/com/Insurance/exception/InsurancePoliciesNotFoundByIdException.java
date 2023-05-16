package com.Insurance.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class InsurancePoliciesNotFoundByIdException extends RuntimeException {

	private String message = "failed to find";
}
