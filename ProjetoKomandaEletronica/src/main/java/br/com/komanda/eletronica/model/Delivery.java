package br.com.komanda.eletronica.model;

import java.util.Date;

public class Delivery {

	private int IdDelivery;
	private double ValorTotal;

	private Date date;
	private Pessoa pessoa;
	private Pedido pedido;
	
	public Delivery(int idDelivery, double valorTotal, Date date, Pessoa pessoa, Pedido pedido) {
		
		IdDelivery = idDelivery;
		ValorTotal = valorTotal;
		this.date = date;
		this.pessoa = pessoa;
		this.pedido = pedido;
	}

	public int getIdDelivery() {
		return IdDelivery;
	}

	public void setIdDelivery(int idDelivery) {
		IdDelivery = idDelivery;
	}

	public double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
	

}
