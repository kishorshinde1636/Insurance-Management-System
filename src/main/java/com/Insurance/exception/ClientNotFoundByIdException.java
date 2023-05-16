package com.Insurance.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientNotFoundByIdException extends RuntimeException {

	private String message = "Client Id Not Found";

}
