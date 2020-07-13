package br.com.compasso.interview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.recrutamento.compasso.entity.City;
import com.recrutamento.compasso.entity.State;
import com.recrutamento.compasso.repository.CityRepository;

import br.com.compasso.interview.service.CityService;

public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository repository;
	
	public City findByName(String name) {
		return repository.findByNameIgnoreCase(name) != null ? repository.findByNameIgnoreCase(name) : null;
	}

	public List<City> findByState(State state) {
		return repository.findByState(state) != null ? repository.findByState(state) : null;
	}

	public City save(City city) {
		return repository.saveAndFlush(city);
	}

	public void remove(City city) {
		repository.delete(city);
		
	}

}
