package br.edu.ufape.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.usuarios.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
