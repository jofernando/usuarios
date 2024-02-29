package br.edu.ufape.usuarios.service.impl;

import br.edu.ufape.usuarios.model.Professor;
import br.edu.ufape.usuarios.repository.ProfessorRepository;
import br.edu.ufape.usuarios.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> recuperarTodos() {
        return professorRepository.findAll();
    }

    public Professor recuperar(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(mensagemNotFound(id))
                );
    }

    public Professor cadastrar(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor atualizar(Long id, Professor professor) {
        professorRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(mensagemNotFound(id))
                );
        professor.setId(id);
        return professorRepository.save(professor);
    }

    public void deletar(Long id) {
        boolean existe = professorRepository.existsById(id);
        if (! existe)
            throw new IllegalArgumentException(mensagemNotFound(id));
        professorRepository.deleteById(id);
    }

    private String mensagemNotFound(Long id) {
        return "Professor com o id: " + id + " não foi encontrado.";
    }
}
