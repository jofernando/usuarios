package br.edu.ufape.usuarios.model;

import java.time.LocalDate;

import br.edu.ufape.usuarios.model.enums.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// id do keycloak
	@NotBlank
	private String userId;
	@Column(unique = true)
	@NotBlank
	private String login;
	@JsonIgnore
	private String senha;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean gestao;
	@NotBlank
	private String nome;
	@NotBlank
	private String curso;
	@NotBlank
	private String celular;
	@NotBlank
	private String rg;
	@NotBlank
	private String orgaoExpedidorRg;
	@Past
	@NotNull
	private LocalDate emissaoRg;
	@NotBlank
	@CPF
	private String cpf;
	private String assinaturaPath;
	@NotNull
	private EstadoCivil estadoCivil;
	@NotBlank
	private String nacionalidade;
	@NotBlank
	private String naturalidade;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean admin;
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private Endereco endereco;
}
