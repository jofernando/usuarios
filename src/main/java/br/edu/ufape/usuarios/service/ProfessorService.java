package br.edu.ufape.usuarios.service;

import br.edu.ufape.usuarios.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> recuperarTodos();
    Professor recuperar(Long id);
    Professor cadastrar(Professor professor);
    Professor atualizar(Long id, Professor professor);
    void deletar(Long id);
}
