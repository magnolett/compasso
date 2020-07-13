package br.com.compasso.interview.service;

import java.util.List;

import com.recrutamento.compasso.entity.City;
import com.recrutamento.compasso.entity.State;

public interface CityService {

	City findByName(String name);
	
	List<City> findByState(State state);
	
	City save(City city);

	void remove(City city);

}
