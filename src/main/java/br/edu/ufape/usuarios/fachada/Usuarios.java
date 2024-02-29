package br.edu.ufape.usuarios.fachada;

import java.util.List;

import br.edu.ufape.usuarios.model.Professor;
import br.edu.ufape.usuarios.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.usuarios.model.Estudante;
import br.edu.ufape.usuarios.service.EstudanteService;

@Service
public class Usuarios {
	
	private final EstudanteService estudanteService;
	private final ProfessorService professorService;

	@Autowired
	public Usuarios(EstudanteService estudanteService, ProfessorService professorService) {
		this.estudanteService = estudanteService;
        this.professorService = professorService;
    }

	public List<Estudante> recuperarEstudantes() {
		return estudanteService.recuperarTodos();
	}

	public Estudante recuperarEstudante(Long id) {
		return estudanteService.recuperar(id);
	}

	public Estudante cadastrar(Estudante estudante) {
		return estudanteService.cadastrar(estudante);
	}

	public Estudante atualizar(Long id, Estudante estudanteRequest) {
		return estudanteService.atualizar(id, estudanteRequest);
	}

	public void deletarEstudante(Long id) {
		estudanteService.deletar(id);
	}

	public List<Professor> recuperarProfessores() {
		return professorService.recuperarTodos();
	}

	public Professor recuperarProfessor(Long id) {
		return professorService.recuperar(id);
	}

	public Professor cadastrar(Professor professor) {
		return professorService.cadastrar(professor);
	}

	public Professor atualizar(Long id, Professor professor) {
		return professorService.atualizar(id, professor);
	}

	public void deletarProfessor(Long id) {
		professorService.deletar(id);
	}
}
