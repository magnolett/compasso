package com.recrutamento.compasso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutamento.compasso.entity.City;
import com.recrutamento.compasso.entity.State;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	City findByNameIgnoreCase(String name);
	
	List<City> findByState(State state);
}
