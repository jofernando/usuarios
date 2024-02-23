package br.edu.ufape.usuarios.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.usuarios.model.Estudante;
import br.edu.ufape.usuarios.service.EstudanteService;

@Service
public class Usuarios {
	
	@Autowired
	private EstudanteService estudanteService;

	public List<Estudante> recuperarTodos() {
		return estudanteService.recuperarTodos();
	}

	public Estudante recuperar(Long id) {
		return estudanteService.recuperar(id);
	}

	public Estudante cadastrar(Estudante estudante) {
		return estudanteService.cadastrar(estudante);
	}

	public Estudante atualizar(Long id, Estudante estudanteRequest) {
		return estudanteService.atualizar(id, estudanteRequest);
	}

	public void deletar(Long id) {
		estudanteService.deletar(id);
	}
}
