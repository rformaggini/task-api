package br.com.tarefas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.domain.Atividade;
import br.com.tarefas.repositories.AtividadeRepository;
import br.com.tarefas.services.exception.ObjectNotFoundException;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public Atividade findById(Integer id) {
		
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		
		return atividade.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado para o ID: " + id));
	}
	
	public Atividade create(Atividade atividade) {
		return atividadeRepository.save(atividade);	
	}
	
	public Atividade update(Atividade atividade) {
		return atividadeRepository.save(atividade);	
	}
	
	public void delete(Integer id) {
		atividadeRepository.deleteById(id);
	}
}
