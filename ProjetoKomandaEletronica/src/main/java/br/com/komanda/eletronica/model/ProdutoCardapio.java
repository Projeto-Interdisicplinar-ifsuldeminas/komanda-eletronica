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

}
