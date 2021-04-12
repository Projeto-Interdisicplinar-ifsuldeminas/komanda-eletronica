package br.com.komanda.eletronica.model;

import br.com.komanda.eletronica.model.Enums.*;

public class Funcionario extends Pessoa {
	
	private int idFuncionario;
	private int NumeroRegistro;
	private boolean IsGerente;
	private boolean IsExcluído;
	private String funcao = TiposdeFuncao.Funcao1.getFuncao();

	public Funcionario(int idPessoa, String nome, String cPF, String endereço, String telefone, String email,
			boolean isFuncionario, boolean isExcuído, int idFuncionario, int numeroRegistro, boolean isGerente,
			boolean isExcluído, String funcao) {
		super(idPessoa, nome, cPF, endereço, telefone, email, isFuncionario, isExcuído);
		this.idFuncionario = idFuncionario;
		NumeroRegistro = numeroRegistro;
		IsGerente = isGerente;
		IsExcluído = isExcluído;
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

	public boolean isIsExcluído() {
		return IsExcluído;
	}

	public void setIsExcluído(boolean isExcluído) {
		IsExcluído = isExcluído;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
	
	

}
