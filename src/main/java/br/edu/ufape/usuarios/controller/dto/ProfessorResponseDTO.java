package br.edu.ufape.usuarios.controller.dto;

import br.edu.ufape.usuarios.config.SpringApplicationContext;
import br.edu.ufape.usuarios.model.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
public class ProfessorResponseDTO extends UsuarioResponseDTO {
	private String especialidade;

	public ProfessorResponseDTO(Professor obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}
}
