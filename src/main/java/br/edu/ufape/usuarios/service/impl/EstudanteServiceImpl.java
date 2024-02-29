package br.edu.ufape.usuarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.usuarios.model.Estudante;
import br.edu.ufape.usuarios.repository.EstudanteRepository;
import br.edu.ufape.usuarios.service.EstudanteService;

@Service
public class EstudanteServiceImpl implements EstudanteService {

	private final EstudanteRepository estudanteRepository;

	@Autowired
	public EstudanteServiceImpl(EstudanteRepository estudanteRepository) {
		this.estudanteRepository = estudanteRepository;
	}

	public List<Estudante> recuperarTodos() {
		return estudanteRepository.findAll();
	}
	
	public Estudante recuperar(Long id) {
		return estudanteRepository.findById(id)
			.orElseThrow(
				() -> new IllegalArgumentException(mensagemNotFound(id))
			);
	}
	
	public Estudante cadastrar(Estudante estudante) {
		return estudanteRepository.save(estudante);
	}
	
	public Estudante atualizar(Long id, Estudante estudanteRequest) {
		estudanteRepository.findById(id)
			.orElseThrow(
				() -> new IllegalArgumentException(mensagemNotFound(id))
			);
		estudanteRequest.setId(id);
		return estudanteRepository.save(estudanteRequest);
	}
	
	public void deletar(Long id) {
		boolean existe = estudanteRepository.existsById(id);
		if (! existe) 
			throw new IllegalArgumentException(mensagemNotFound(id));
		estudanteRepository.deleteById(id);
	}
	
	private String mensagemNotFound(Long id) {
		return "Estudante com o id: " + id + " não foi encontrado.";
	}
}
