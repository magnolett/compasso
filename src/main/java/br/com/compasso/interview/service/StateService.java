package br.com.compasso.interview.service;

import com.recrutamento.compasso.entity.State;

public interface StateService {

	State save(State state);

	void remove(State state);
	
	State findByName(String name);


}
