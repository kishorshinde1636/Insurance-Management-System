package com.Insurance.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceClaimIdNotFoundException extends RuntimeException {

	private String message = "failed to find Id";
}
