package br.edu.ufape.usuarios.service;

import java.util.List;

import br.edu.ufape.usuarios.model.Estudante;

public interface EstudanteService {
	List<Estudante> recuperarTodos();
	Estudante recuperar(Long id);
	Estudante cadastrar(Estudante estudante);
	Estudante atualizar(Long id, Estudante estudante);
	void deletar(Long id);
}
