package br.com.komanda.eletronica.model;

public class TiposdeFuncao {

	private int idFuncao;
	private String funcao;
	
	

	public TiposdeFuncao(int idFuncao, String funcao) {
		this.idFuncao = idFuncao;
		this.funcao = funcao;
	}
	
	public TiposdeFuncao() {
		
	}

	public String getFuncao() {
		return funcao;
	}

	public int getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
	}

}
