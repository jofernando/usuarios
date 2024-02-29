package br.edu.ufape.usuarios.controller;

import br.edu.ufape.usuarios.controller.dto.ProfessorRequestDTO;
import br.edu.ufape.usuarios.controller.dto.ProfessorResponseDTO;
import br.edu.ufape.usuarios.fachada.Usuarios;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("professores")
public class ProfessorController {

	private final Usuarios usuarios;

	@Autowired
    public ProfessorController(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @PostMapping
	public ProfessorResponseDTO cadastrar(@RequestBody @Valid ProfessorRequestDTO requestDTO) {
		return new ProfessorResponseDTO(usuarios.cadastrar(requestDTO.convertToEntity()));
	}

	@GetMapping
	public List<ProfessorResponseDTO> buscarTodos() {
		return usuarios.recuperarProfessores().stream().map(ProfessorResponseDTO::new).toList();
	}

	@GetMapping("{id}")
	public ProfessorResponseDTO buscarPorId(@PathVariable Long id) {
		return new ProfessorResponseDTO(usuarios.recuperarProfessor(id));
	}

	@PatchMapping("{id}")
	public ProfessorResponseDTO alterar(@PathVariable Long id, @RequestBody @Valid ProfessorRequestDTO requestDTO) {
		return new ProfessorResponseDTO(usuarios.atualizar(id, requestDTO.convertToEntity()));
	}

	@DeleteMapping("{id}")
	public void deletar(@PathVariable Long id) {
		usuarios.deletarProfessor(id);
	}
}
