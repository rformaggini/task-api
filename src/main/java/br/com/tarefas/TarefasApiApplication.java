package br.com.tarefas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tarefas.domain.Atividade;
import br.com.tarefas.domain.Tarefa;
import br.com.tarefas.repositories.TarefaRepository;

@SpringBootApplication
public class TarefasApiApplication implements CommandLineRunner {
	
	@Autowired
	private TarefaRepository tarefaRepository;
		

	public static void main(String[] args) {
		SpringApplication.run(TarefasApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		
		
		Atividade atividade1 = new Atividade(null, "Comprar frutas", data, false );
		Atividade atividade2 = new Atividade(null, "Molhar as plantas", data, false);
		
		Tarefa tarefa = new Tarefa(null, "Atividades de Casa");
		
		atividade1.setTarefa(tarefa);
		atividade2.setTarefa(tarefa);
		
		List<Atividade> listAtividades = new ArrayList<Atividade>();
		listAtividades.add(atividade1);
		listAtividades.add(atividade2);
		
		tarefa.setAtividade(listAtividades);
		
		tarefaRepository.saveAll(Arrays.asList(tarefa));
	
		
	}

}
