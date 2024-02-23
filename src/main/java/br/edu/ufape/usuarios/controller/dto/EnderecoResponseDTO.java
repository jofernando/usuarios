package br.edu.ufape.usuarios.controller.dto;

import org.modelmapper.ModelMapper;

import br.edu.ufape.usuarios.config.SpringApplicationContext;
import br.edu.ufape.usuarios.model.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoResponseDTO {
	private Long id;
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	
	public EnderecoResponseDTO(Endereco obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}
}
