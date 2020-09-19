package br.com.tarefas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.domain.Tarefa;
import br.com.tarefas.repositories.TarefaRepository;
import br.com.tarefas.services.exception.ObjectNotFoundException;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public Tarefa buscar(Integer id) {
		
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		
		return tarefa.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado para o ID: " + id));
	}

	public Tarefa salvar(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);	
	}
	
	public Tarefa atualizar(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);	
	}
	
	public void deletar(Tarefa tarefa) {
		tarefaRepository.delete(tarefa);
	}
	
}
