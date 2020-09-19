package br.com.tarefas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.domain.Tarefa;
import br.com.tarefas.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public Tarefa buscar(Integer id) {
		
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		
		return tarefa.orElse(null);
	}

}
