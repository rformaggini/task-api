package br.com.tarefas.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/tarefas")
public class TarefaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST OK";
	}

}
