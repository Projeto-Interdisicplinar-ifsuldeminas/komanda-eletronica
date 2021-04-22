package br.com.komanda.eletronica.model;

public class Funcionario extends Pessoa {
	
	private int idFuncionario;
	private int NumeroRegistro;
	private int idFuncao;
	private boolean IsGerente;
	private boolean IsExcluido;

	

	public Funcionario(int idPessoa, String nome, String cPF, String endereço, String telefone, String email,
			boolean isFuncionario, boolean isExcuído, int idFuncionario, int numeroRegistro, boolean isGerente,
			boolean isExcluído, int idFunc) {
		super(idPessoa, nome, cPF, endereço, telefone, email, isExcuído);
		this.idFuncionario = idFuncionario;
		this.NumeroRegistro = numeroRegistro;
		this.IsGerente = isGerente;
		this.IsExcluido = isExcluído;
		this.idFuncao = idFunc;
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

	public boolean isIsExcluido() {
		return IsExcluido;
	}

	public void setIsExcluido(boolean isExcluido) {
		IsExcluido = isExcluido;
	}

	public int getIdFuncao() {
		return idFuncao;
	}

	public void setIdFuncao(int idFuncao) {
		this.idFuncao = idFuncao;
	}

	
	
	

}
