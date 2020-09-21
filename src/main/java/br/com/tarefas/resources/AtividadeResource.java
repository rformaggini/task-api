package br.com.tarefas.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tarefas.domain.Atividade;
import br.com.tarefas.services.AtividadeService;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeResource {
	
	@Autowired
	private AtividadeService atividadeService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Atividade> findById(@PathVariable Integer id){
		
		Atividade atividade = atividadeService.findById(id);
		
		return ResponseEntity.ok().body(atividade);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Atividade atividade){
		
		Atividade novaAtividade = atividadeService.create(atividade);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(novaAtividade.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Atividade atividade){
		atividade = atividadeService.update(atividade);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		atividadeService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
