package br.edu.ufape.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.usuarios.controller.dto.EstudanteRequestDTO;
import br.edu.ufape.usuarios.fachada.Usuarios;
import br.edu.ufape.usuarios.model.Estudante;

public class EstudanteController {

	private Usuarios usuarios;
	
	public EstudanteRequestDTO cadastrar(EstudanteRequestDTO estudanteRequestDTO) {
		return estudanteRequestDTO;
	}
}
