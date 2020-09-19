package br.com.tarefas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefas.domain.Atividade;
import br.com.tarefas.services.AtividadeService;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeResource {
	
	@Autowired
	private AtividadeService atividadeServico;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		Atividade atividade = atividadeServico.buscar(id);
		
		return ResponseEntity.ok().body(atividade);
	}
	

}
