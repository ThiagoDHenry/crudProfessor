package com.aula.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.aula.validation.produto.ProdutoInsert;

import java.math.BigDecimal;

@ProdutoInsert
public class ProdutoNewDTO {
    @NotBlank(message = "O nome do produto não pode estar em branco")
    private String nome;

    @NotNull(message = "O preço do produto não pode ser nulo")
    @Positive(message = "O preço do produto deve ser positivo")
    private BigDecimal preco;

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

	public ProdutoNewDTO(@NotBlank(message = "O nome do produto não pode estar em branco") String nome,
			@NotNull(message = "O preço do produto não pode ser nulo") @Positive(message = "O preço do produto deve ser positivo") BigDecimal preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

    public ProdutoNewDTO() {}
}