package br.com.komanda.eletronica.model.Enums;

public enum TiposdeFuncao {

	Funcao1("Garçom"), 
	Funcao2("Cozinheiro"), 
	Funcao3("Auxiliar de Cozinha"), 
	Funcao4("Faxineira");

	private String funcao;

	private TiposdeFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

}
