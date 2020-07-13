package com.recrutamento.compasso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recrutamento.compasso.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {
	
	State findByName(String name);
}
