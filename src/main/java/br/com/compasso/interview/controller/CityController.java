package br.com.compasso.interview.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recrutamento.compasso.dto.CityDto;
import com.recrutamento.compasso.entity.City;
import com.recrutamento.compasso.entity.State;
import com.recrutamento.compasso.repository.CityRepository;

@RestController
public class CityController {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ModelMapper mapper;

	@RequestMapping(value = "/city", method = RequestMethod.POST)
	public ResponseEntity<City> createCity(@RequestBody CityDto city) {
		if (cityRepository.findByNameIgnoreCase(city.getNome()) != null) {
			return new ResponseEntity<City>(HttpStatus.OK);
		}
		final City saveAndFlush = cityRepository.saveAndFlush(convertToEntity(city));
		return new ResponseEntity<City>(saveAndFlush, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/city/name", method = RequestMethod.GET)
	public City findCityByName(@RequestParam("name") String name) {
		return cityRepository.findByNameIgnoreCase(name);
	}

	@RequestMapping(value = "/city/state", method = RequestMethod.GET)
    public ResponseEntity<List<City>> findCityByState(@RequestParam("state") State state) {
		final List<City> findByState = cityRepository.findByState(state);
		
		if(findByState == null) {
			return new ResponseEntity<List<City>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<City>>(findByState, HttpStatus.OK);
	}
	
	private City convertToEntity(CityDto city) {
		return mapper.map(city, City.class);
	}

}
