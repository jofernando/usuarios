package br.edu.ufape.usuarios.controller.dto;

import java.time.LocalDate;

import br.edu.ufape.usuarios.model.Endereco;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import br.edu.ufape.usuarios.config.SpringApplicationContext;
import br.edu.ufape.usuarios.model.Estudante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstudanteRequestDTO extends UsuarioRequestDTO {
	private String matricula;

	public Estudante convertToEntity() {
		ModelMapper mm = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		return mm.map(this, Estudante.class);
	}
}
