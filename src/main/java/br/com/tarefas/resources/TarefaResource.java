package br.com.tarefas.resources;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefas.domain.Tarefa;
import br.com.tarefas.services.TarefaService;

@RestController
@RequestMapping(value ="/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaService tarefaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Tarefa tarefa = tarefaService.buscar(id);
		
		return ResponseEntity.ok().body(tarefa);
	}

}
