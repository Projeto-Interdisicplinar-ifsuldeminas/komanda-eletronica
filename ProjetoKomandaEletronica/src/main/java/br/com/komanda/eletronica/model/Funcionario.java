package br.com.komanda.eletronica.model;

import br.com.komanda.eletronica.model.Enums.*;

public class Funcionario extends Pessoa {
	
	private int idFuncionario;
	private int NumeroRegistro;
	private boolean IsGerente;
	private boolean IsExclu�do;
	private String funcao = TiposdeFuncao.Funcao1.getFuncao();

	public Funcionario(int idPessoa, String nome, String cPF, String endere�o, String telefone, String email,
			boolean isFuncionario, boolean isExcu�do, int idFuncionario, int numeroRegistro, boolean isGerente,
			boolean isExclu�do, String funcao) {
		super(idPessoa, nome, cPF, endere�o, telefone, email, isFuncionario, isExcu�do);
		this.idFuncionario = idFuncionario;
		NumeroRegistro = numeroRegistro;
		IsGerente = isGerente;
		IsExclu�do = isExclu�do;
		this.funcao = funcao;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getNumeroRegistro() {
		return NumeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		NumeroRegistro = numeroRegistro;
	}

	public boolean isIsGerente() {
		return IsGerente;
	}

	public void setIsGerente(boolean isGerente) {
		IsGerente = isGerente;
	}

	public boolean isIsExclu�do() {
		return IsExclu�do;
	}

	public void setIsExclu�do(boolean isExclu�do) {
		IsExclu�do = isExclu�do;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	
	

}
