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
public class EstudanteResponseDTO {
	private Long id;
	private String login;
	private String senha;
	private boolean gestao;
	private String nome;
	private String curso;
	private String celular;
	private String rg;
	private String orgaoExpedidorRg;
	private LocalDate emissaoRg;
	private String cpf;
	private String assinaturaPath;
	private String estadoCivil;
	private String nacionalidade;
	private String naturalidade;
	private boolean admin;
	private EnderecoResponseDTO endereco;
	
	public EstudanteResponseDTO(Estudante obj) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(obj, this);
	}
}
