package br.edu.ufape.usuarios.controller;

import br.edu.ufape.usuarios.controller.dto.EstudanteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.usuarios.controller.dto.EstudanteRequestDTO;
import br.edu.ufape.usuarios.fachada.Usuarios;

import java.util.List;

@RestController
@RequestMapping("estudantes")
public class EstudanteController {

	private final Usuarios usuarios;

	@Autowired
    public EstudanteController(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @PostMapping
	public EstudanteResponseDTO cadastrar(@RequestBody @Valid EstudanteRequestDTO requestDTO) {
		return new EstudanteResponseDTO(usuarios.cadastrar(requestDTO.convertToEntity()));
	}

	@GetMapping
	public List<EstudanteResponseDTO> buscarTodos() {
		return usuarios.recuperarEstudantes().stream().map(EstudanteResponseDTO::new).toList();
	}

	@GetMapping("{id}")
	public EstudanteResponseDTO buscarPorId(@PathVariable Long id) {
		return new EstudanteResponseDTO(usuarios.recuperarEstudante(id));
	}

	@PatchMapping("{id}")
	public EstudanteResponseDTO alterar(@PathVariable Long id, @RequestBody @Valid EstudanteRequestDTO requestDTO) {
		return new EstudanteResponseDTO(usuarios.atualizar(id, requestDTO.convertToEntity()));
	}

	@DeleteMapping("{id}")
	public void deletar(@PathVariable Long id) {
		usuarios.deletarEstudante(id);
	}
}
