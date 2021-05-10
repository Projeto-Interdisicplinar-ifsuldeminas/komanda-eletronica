package br.com.komanda.eletronica.model;

public class ProdutoCardapio {
	private int IdProdutoCardapio;
	private String Nome;
	private double Peso;
	private String Descricao;
	private double Valor;
	private String informacoesNutricionais;
	private int QuantidadeDePessoasQueServe;
	private boolean IsExcluido;

	public ProdutoCardapio(int idProdutoCardapio, String nome, double peso, String descricao, double valor,
			String informacoesNutricionais, int quantidadeDePessoasQueServe, boolean isExcluido) {

		IdProdutoCardapio = idProdutoCardapio;
		Nome = nome;
		Peso = peso;
		Descricao = descricao;
		Valor = valor;
		this.informacoesNutricionais = informacoesNutricionais;
		QuantidadeDePessoasQueServe = quantidadeDePessoasQueServe;
		IsExcluido = isExcluido;
	}

	public ProdutoCardapio(String nome, double peso, String descricao, double valor, String informacoesNutricionais,
			int quantidadeDePessoasQueServe, boolean isExcluido) {
		Nome = nome;
		Peso = peso;
		Descricao = descricao;
		Valor = valor;
		this.informacoesNutricionais = informacoesNutricionais;
		QuantidadeDePessoasQueServe = quantidadeDePessoasQueServe;
		IsExcluido = isExcluido;
	}
	
	

	public ProdutoCardapio(int idProdutoCardapio, String nome, double peso, String descricao, double valor,
			String informacoesNutricionais, int quantidadeDePessoasQueServe) {
		IdProdutoCardapio = idProdutoCardapio;
		Nome = nome;
		Peso = peso;
		Descricao = descricao;
		Valor = valor;
		this.informacoesNutricionais = informacoesNutricionais;
		QuantidadeDePessoasQueServe = quantidadeDePessoasQueServe;
	}
	
	public ProdutoCardapio() {
		
	}
	
	public String toString() {
		return this.IdProdutoCardapio + " - " + this.Nome;
	}
	

	public int getIdProdutoCardapio() {
		return IdProdutoCardapio;
	}

	public void setIdProdutoCardapio(int idProdutoCardapio) {
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

	public String getInformacoesNutricionais() {
		return informacoesNutricionais;
	}

	public void setInformacoesNutricionais(String informacoesNutricionais) {
		this.informacoesNutricionais = informacoesNutricionais;
	}

	public int getQuantidadeDePessoasQueServe() {
		return QuantidadeDePessoasQueServe;
	}

	public void setQuantidadeDePessoasQueServe(int quantidadeDePessoasQueServe) {
		QuantidadeDePessoasQueServe = quantidadeDePessoasQueServe;
	}

	public boolean isIsExcluido() {
		return IsExcluido;
	}

	public void setIsExcluido(boolean isExcluido) {
		IsExcluido = isExcluido;
	}

}
