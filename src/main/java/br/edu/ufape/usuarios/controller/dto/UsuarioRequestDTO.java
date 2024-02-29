package br.edu.ufape.usuarios.controller.dto;

import br.edu.ufape.usuarios.model.enums.EstadoCivil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioRequestDTO
{
    private String login;
    // id do keycloak
    private String userId;
    private String senha;
    private String nome;
    private String curso;
    private String celular;
    private String rg;
    private String orgaoExpedidorRg;
    private LocalDate emissaoRg;
    private String cpf;
    private boolean gestao;
    private EstadoCivil estadoCivil;
    private String nacionalidade;
    private String naturalidade;
    private EnderecoRequestDTO endereco;

}
