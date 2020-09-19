package br.com.tarefas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.domain.Atividade;
import br.com.tarefas.repositories.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public Atividade buscar(Integer id) {
		
		Optional<Atividade> atividade = atividadeRepository.findById(id);
		
		return atividade.orElse(null);
		
	}
}
