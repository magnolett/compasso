package br.com.compasso.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recrutamento.compasso.entity.State;
import com.recrutamento.compasso.repository.StateRepository;

@RestController
public class StateController {

	@Autowired
	private StateRepository repository;
	
	@RequestMapping(value = "/states", method = RequestMethod.POST)
    public String createStates() {
		
		createFirstStates("Acre", "AC");
		createFirstStates("Alagoas", "AL");
		createFirstStates("Amap�", "AP");
		createFirstStates("Amazonas", "AM");
		createFirstStates("Bahia", "BA");
		createFirstStates("Cear�", "CE");
		createFirstStates("Distrito Federal", "DF");
		createFirstStates("Esp�rito Santo", "ES");
		createFirstStates("Goi�s", "GO");
		createFirstStates("Maranhh�o", "MA");
		createFirstStates("Mato Grosso", "MT");
		createFirstStates("Mato Grosso do Sul", "MS");
		createFirstStates("Minas Gerais", "MG");
		createFirstStates("Par�", "PA");
		createFirstStates("Para�ba", "PB");
		createFirstStates("Paran�", "PR");
		createFirstStates("Pernambuco", "PE");
		createFirstStates("Piau�", "PI");
		createFirstStates("Rio de Janeiro", "RJ");
		createFirstStates("Rio Grande do Norte", "RN");
		createFirstStates("Rio Grande do Sul", "RS");
		createFirstStates("Rond�nia", "RO");
		createFirstStates("Roraima", "RR");
		createFirstStates("Santa Catarina", "SC");
		createFirstStates("S�o Paulo", "SP");
		createFirstStates("Sergipe", "SE");
		createFirstStates("Tocantins", "TO");
		
        return "Estados cadastrados com sucesso";
    }
	
	@RequestMapping("/state/list")
    public List<State> listStates() {
        return repository.findAll();
    }
	
	private void createFirstStates(String name, String uf) {
		
		final State state = new State();
		state.setName(name);
		state.setUf(uf);
		
		final State temp = repository.findByName(name);
		if(temp == null) {
			repository.save(state);
		}
	}
}
