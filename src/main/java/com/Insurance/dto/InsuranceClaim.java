package com.Insurance.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class InsuranceClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Long number;

	private String description;

	private Date date;

	private String status;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "policy_id")
//	private InsurancePolicies insurancePolicies;

	
}
