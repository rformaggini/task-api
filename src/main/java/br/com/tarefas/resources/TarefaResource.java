package br.com.tarefas.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefas.domain.Tarefa;

@RestController
@RequestMapping(value ="/tarefas")
public class TarefaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tarefa> listar() {
		
		Tarefa tarefa1 = new Tarefa();
		Tarefa tarefa2 = new Tarefa();
		
		List<Tarefa> listaTarefas= new ArrayList<Tarefa>();
		
		listaTarefas.add(tarefa1);
		listaTarefas.add(tarefa2);
		
		return listaTarefas;
	}

}
