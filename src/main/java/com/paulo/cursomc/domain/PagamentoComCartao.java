package com.paulo.cursomc.domain;

import javax.persistence.Entity;

import com.paulo.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao  extends Pagamento	{
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private Integer numeroDeParcelas;
	
	//Construtores
	
	public PagamentoComCartao () {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.setNumeroDeParcelas(numeroDeParcelas);
	}
	
	// getters e Setters

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
