package com.Insurance.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class InsurancePolicies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Long number;

	private String type;

	private Double coverageAmount;

	private Double premium;

	private Date startDate;

	private Date endDate;

//	@ManyToOne
//	@JoinColumn(name = "client_id")
//	private Client client;
//
//	@OneToMany(mappedBy = "insurancePolicies", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<InsuranceClaim> claims;

	
}
