package com.aula.domain.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.aula.validation.cliente.ClienteInsert;


@ClienteInsert
public class ClienteNewDTO {
    @NotBlank(message = "O nome do cliente é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF do cliente é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido")
    private String cpf;

    private String telefone;

    @NotBlank(message = "O email do cliente é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	

	public ClienteNewDTO(@NotBlank(message = "O nome do cliente é obrigatório") String nome,
			@NotBlank(message = "O CPF do cliente é obrigatório") @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido") String cpf,
			String telefone,
			@NotBlank(message = "O email do cliente é obrigatório") @Email(message = "Email inválido") String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}



	public ClienteNewDTO() {

	}
}
