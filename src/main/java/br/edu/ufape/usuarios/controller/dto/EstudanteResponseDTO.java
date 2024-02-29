package br.edu.ufape.usuarios.controller.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import br.edu.ufape.usuarios.config.SpringApplicationContext;
import br.edu.ufape.usuarios.model.Estudante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstudanteResponseDTO extends UsuarioResponseDTO {
	private String matricula;

	public EstudanteResponseDTO(Estudante obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}
}
