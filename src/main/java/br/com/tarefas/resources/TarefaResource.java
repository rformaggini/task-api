package br.com.tarefas.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Tarefa tarefa){
		
		Tarefa novaTarefa = tarefaService.salvar(tarefa);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novaTarefa.getId())
				.toUri();
		return ResponseEntity.created(uri).build();	
	}
	

}
