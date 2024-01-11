package br.edu.ufape.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.usuarios.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
