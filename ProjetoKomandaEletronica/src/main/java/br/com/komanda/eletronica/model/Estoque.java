package br.com.komanda.eletronica.model;

import java.util.ArrayList;

public class Estoque {

	private int IdEstoque;
	private double Quantidade;
	private ProdutoEstoque produtoEstoque;
	private ArrayList<ProdutoEstoque> listaProdutos;
	
	public Estoque(int idEstoque, double quantidade, ProdutoEstoque produtoEstoque) {
		IdEstoque = idEstoque;
		Quantidade = quantidade;
		this.produtoEstoque = produtoEstoque;
	}

	public int getIdEstoque() {
		return IdEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		IdEstoque = idEstoque;
	}

	public double getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(double quantidade) {
		Quantidade = quantidade;
	}

	public ProdutoEstoque getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(ProdutoEstoque produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}
	
	public void AdicionaProdutoLista(ProdutoEstoque produto) {
		listaProdutos.add(produto);
	}
	

}
