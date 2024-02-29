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
public class ProfessorRequestDTO extends UsuarioRequestDTO {
	private String especialidade;

	public Professor convertToEntity() {
		ModelMapper mm = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		return mm.map(this, Professor.class);
	}
}
