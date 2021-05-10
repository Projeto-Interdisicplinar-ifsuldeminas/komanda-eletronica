package br.com.komanda.eletronica.model;

import java.util.ArrayList;

public class Pedido {

	private int IdPedido;
	private Mesa mesa;
	private ProdutoCardapio produtoCardapio;
	private int quantidade, status;
	private ArrayList<ProdutoCardapio> produtocardapio = new ArrayList<>();
	
	public Pedido() {
		
	}

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public void setProdutocardapio(ArrayList<ProdutoCardapio> produtocardapio) {
		this.produtocardapio = produtocardapio;
	}

	public ProdutoCardapio getProdutoCardapio() {
		return produtoCardapio;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setProdutoCardapio(ProdutoCardapio produtoCardapio) {
		this.produtoCardapio = produtoCardapio;
	}

	public ArrayList<ProdutoCardapio> getProdutocardapio() {
		return produtocardapio;
	}

	public void setProdutocardapioLista(ArrayList<ProdutoCardapio> produtocardapio) {
		this.produtocardapio = produtocardapio;
	}
	
	public ProdutoCardapio getProdutoPeloIndex(int i) {
		return this.produtocardapio.get(i);
	}
	

}
