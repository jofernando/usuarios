package br.edu.ufape.usuarios.controller.dto;

import java.time.LocalDate;

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
public class EstudanteRequestDTO {
	private String login;
	private String senha;
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
	private String matricula;
	private EnderecoRequestDTO endereco;
	
	public Estudante convertToEntity() {
		ModelMapper mm = new ModelMapper();
		mm.getConfiguration().setSkipNullEnabled(true);
		TypeMap<EstudanteRequestDTO, Estudante> typeMap = mm.createTypeMap(EstudanteRequestDTO.class, Estudante.class);
		typeMap.addMapping(EstudanteRequestDTO::getNome, Estudante::setNome);
		typeMap.addMapping(EstudanteRequestDTO::getLogin, Estudante::setLogin);
		typeMap.addMapping(EstudanteRequestDTO::getSenha, Estudante::setSenha);
		typeMap.addMapping(EstudanteRequestDTO::getCurso, Estudante::setCurso);
		typeMap.addMapping(EstudanteRequestDTO::getMatricula, Estudante::setMatricula);
		return mm.map(this, Estudante.class);
	}
}
