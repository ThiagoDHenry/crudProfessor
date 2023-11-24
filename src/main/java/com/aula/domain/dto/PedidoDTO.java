package com.aula.domain.dto;

import java.time.LocalDate;

import com.aula.validation.pedido.PedidoUpdate;

@PedidoUpdate
public class PedidoDTO {

    private Long id;
	private LocalDate dataPedido;
    private Double valor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public PedidoDTO(Long id, LocalDate dataPedido, Double valor) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.valor = valor;
	}
    
   public PedidoDTO() {
	   
   }
}
