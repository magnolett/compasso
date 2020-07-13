package br.com.compasso.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.recrutamento.compasso.entity.State;
import com.recrutamento.compasso.repository.StateRepository;

import br.com.compasso.interview.service.StateService;

public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository repository;
	
	public State save(State state) {
		return repository.save(state);
	}

	public void remove(State state) {
		repository.delete(state);
	}

	public State findByName(String name) {
		return repository.findByName(name) != null ? repository.findByName(name) : null;
	}

}
