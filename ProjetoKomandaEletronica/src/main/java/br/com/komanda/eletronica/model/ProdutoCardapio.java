package br.com.komanda.eletronica.model;

import br.com.komanda.eletronica.model.Enums.*;

public class ProdutoCardapio {
	private String IdProdutoCardapio;
	private String Nome;
	private double Peso;
	private String Descricao;
	private double Valor;
	private String informaçõesNutricionais;
	private int QuantidadeDePessoasQueServe;
	private int Quantidade;
	private boolean IsExcluido;

	private String produto = TipoDeProduto.Produto1.getProduto();

	public ProdutoCardapio(String idProdutoCardapio, String nome, double peso, String descricao, double valor,
			String informaçõesNutricionais, int quantidadeDePessoasQueServe, int quantidade, boolean isExcluido,
			String produto) {
		IdProdutoCardapio = idProdutoCardapio;
		Nome = nome;
		Peso = peso;
		Descricao = descricao;
		Valor = valor;
		this.informaçõesNutricionais = informaçõesNutricionais;
		QuantidadeDePessoasQueServe = quantidadeDePessoasQueServe;
		Quantidade = quantidade;
		IsExcluido = isExcluido;
		this.produto = produto;
	}

	public String getIdProdutoCardapio() {
		return IdProdutoCardapio;
	}

	public void setIdProdutoCardapio(String idProdutoCardapio) {
		IdProdutoCardapio = idProdutoCardapio;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public String getInformaçõesNutricionais() {
		return informaçõesNutricionais;
	}

	public void setInformaçõesNutricionais(String informaçõesNutricionais) {
		this.informaçõesNutricionais = informaçõesNutricionais;
	}

	public int getQuantidadeDePessoasQueServe() {
		return QuantidadeDePessoasQueServe;
	}

	public void setQuantidadeDePessoasQueServe(int quantidadeDePessoasQueServe) {
		QuantidadeDePessoasQueServe = quantidadeDePessoasQueServe;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public boolean isIsExcluido() {
		return IsExcluido;
	}

	public void setIsExcluido(boolean isExcluido) {
		IsExcluido = isExcluido;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	

}
