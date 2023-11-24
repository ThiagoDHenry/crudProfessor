package com.aula.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.aula.validation.produto.ProdutoUpdate;

import java.math.BigDecimal;

@ProdutoUpdate
public class ProdutoDTO {
	
    private Long id;

    @NotBlank(message = "O nome do produto não pode estar em branco")
    private String nome;

    @NotNull(message = "O preço do produto não pode ser nulo")
    @Positive(message = "O preço do produto deve ser positivo")
    private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public ProdutoDTO(Long id, @NotBlank(message = "O nome do produto não pode estar em branco") String nome,
			@NotNull(message = "O preço do produto não pode ser nulo") @Positive(message = "O preço do produto deve ser positivo") BigDecimal preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

    public ProdutoDTO() {}
}
