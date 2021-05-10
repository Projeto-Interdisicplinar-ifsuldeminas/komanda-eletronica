package br.com.komanda.eletronica.model;

public class ProdutoEstoque {

	private int IdProdutoEstoque;
	private String Nome;
	private double Peso;
	private String Descri��o;
	private String informa��esAdicionais;
	private boolean IsExcluido;
	
	public ProdutoEstoque(int idProdutoEstoque, String nome, double peso, String descri��o,
			String informa��esAdicionais, boolean isExcluido) {
		IdProdutoEstoque = idProdutoEstoque;
		Nome = nome;
		Peso = peso;
		Descri��o = descri��o;
		this.informa��esAdicionais = informa��esAdicionais;
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

	public String getDescri��o() {
		return Descri��o;
	}

	public void setDescri��o(String descri��o) {
		Descri��o = descri��o;
	}

	public String getInforma��esAdicionais() {
		return informa��esAdicionais;
	}

	public void setInforma��esAdicionais(String informa��esAdicionais) {
		this.informa��esAdicionais = informa��esAdicionais;
	}

	public boolean isIsExcluido() {
		return IsExcluido;
	}

	public void setIsExcluido(boolean isExcluido) {
		IsExcluido = isExcluido;
	}
	
	

}
