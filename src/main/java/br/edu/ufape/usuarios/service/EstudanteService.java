package br.edu.ufape.usuarios.service;

import java.util.List;

import br.edu.ufape.usuarios.model.Estudante;

public interface EstudanteService {
	public List<Estudante> recuperarTodos();
	public Estudante recuperar(Long id);
	public Estudante cadastrar(Estudante estudante);
	public Estudante atualizar(Long id, Estudante estudanteRequest);
	public void deletar(Long id);
}
