package br.com.komanda.eletronica.model;

public class ProdutoEstoque {

	private int IdProdutoEstoque;
	private String Nome;
	private double Peso;
	private String Descrição;
	private String informaçõesAdicionais;
	private boolean IsExcluido;
	
	public ProdutoEstoque(int idProdutoEstoque, String nome, double peso, String descrição,
			String informaçõesAdicionais, boolean isExcluido) {
		IdProdutoEstoque = idProdutoEstoque;
		Nome = nome;
		Peso = peso;
		Descrição = descrição;
		this.informaçõesAdicionais = informaçõesAdicionais;
		IsExcluido = isExcluido;
	}

	public int getIdProdutoEstoque() {
		return IdProdutoEstoque;
	}

	public void setIdProdutoEstoque(int idProdutoEstoque) {
		IdProdutoEstoque = idProdutoEstoque;
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

	public String getDescrição() {
		return Descrição;
	}

	public void setDescrição(String descrição) {
		Descrição = descrição;
	}

	public String getInformaçõesAdicionais() {
		return informaçõesAdicionais;
	}

	public void setInformaçõesAdicionais(String informaçõesAdicionais) {
		this.informaçõesAdicionais = informaçõesAdicionais;
	}

	public boolean isIsExcluido() {
		return IsExcluido;
	}

	public void setIsExcluido(boolean isExcluido) {
		IsExcluido = isExcluido;
	}
	
	

}
