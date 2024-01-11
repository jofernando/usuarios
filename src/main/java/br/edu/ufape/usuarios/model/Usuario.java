package br.edu.ufape.usuarios.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	private boolean gestao = false;
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
	private boolean admin = false;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
}
