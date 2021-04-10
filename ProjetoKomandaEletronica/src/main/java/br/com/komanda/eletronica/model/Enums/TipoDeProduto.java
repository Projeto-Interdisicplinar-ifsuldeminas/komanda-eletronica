package br.com.komanda.eletronica.model.Enums;

public enum TipoDeProduto {

	Produto1("Bolinho de bacalhau"), 
	Produto2("Coxinha"), 
	Produto3("Frango à passarinho");

	private String produto;

	private TipoDeProduto(String produto) {
		this.produto = produto;
	}

	public String getProduto() {
		return produto;
	}

}
