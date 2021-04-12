package br.com.komanda.eletronica.model;

import java.util.ArrayList;

public class Pedido {

	private int IdPedido;
	private ProdutoCardapio produtoCardapio;
	private ArrayList<ProdutoCardapio> produtocardapio = new ArrayList<>();
	
	public Pedido() {
		
	}

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public ProdutoCardapio getProdutoCardapio() {
		return produtoCardapio;
	}

	public void setProdutoCardapio(ProdutoCardapio produtoCardapio) {
		this.produtoCardapio = produtoCardapio;
	}

	public ArrayList<ProdutoCardapio> getProdutocardapio() {
		return produtocardapio;
	}

	public void setProdutocardapio(ArrayList<ProdutoCardapio> produtocardapio) {
		this.produtocardapio = produtocardapio;
	}
	
	

}
