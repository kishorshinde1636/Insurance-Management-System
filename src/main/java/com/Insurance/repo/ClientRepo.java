package com.Insurance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Insurance.dto.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {

}
