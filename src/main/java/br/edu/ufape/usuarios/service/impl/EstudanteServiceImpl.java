package br.edu.ufape.usuarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ufape.usuarios.model.Estudante;
import br.edu.ufape.usuarios.repository.EstudanteRepository;
import br.edu.ufape.usuarios.service.EstudanteService;

@Service
public class EstudanteServiceImpl implements EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	public List<Estudante> recuperarTodos() {
		return estudanteRepository.findAll();
	}
	
	public Estudante recuperar(Long id) {
		return estudanteRepository.findById(id)
			.orElseThrow(
				() -> new ResourceNotFoundException(mensagemNotFound(id))
			);
	}
	
	public Estudante cadastrar(Estudante estudante) {
		return estudanteRepository.save(estudante);
	}
	
	public Estudante atualizar(Long id, Estudante estudanteRequest) {
		Estudante estudante = estudanteRepository.findById(id)
			.orElseThrow(
				() -> new ResourceNotFoundException(mensagemNotFound(id))
			);
		// atualizar dados do estudante com os dados que vieram do request
		return estudanteRepository.save(estudante);
	}
	
	public void deletar(Long id) {
		boolean existe = estudanteRepository.existsById(id);
		if (! existe) 
			throw new ResourceNotFoundException(mensagemNotFound(id));
		estudanteRepository.deleteById(id);
	}
	
	private String mensagemNotFound(Long id) {
		return new StringBuilder("Estudante com o id: ").append(id).append(" não foi encontrado.").toString();
	}
}
