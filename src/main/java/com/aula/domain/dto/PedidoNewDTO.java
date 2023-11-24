package com.aula.domain.dto;

import java.time.LocalDate;

import com.aula.validation.pedido.PedidoInsert;


@PedidoInsert
public class PedidoNewDTO {

	private Long Id;
	private LocalDate dataPedido;
    private Double valor;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public PedidoNewDTO(Long id, LocalDate dataPedido, Double valor) {
		super();
		Id = id;
		this.dataPedido = dataPedido;
		this.valor = valor;
	}
    
    
}
