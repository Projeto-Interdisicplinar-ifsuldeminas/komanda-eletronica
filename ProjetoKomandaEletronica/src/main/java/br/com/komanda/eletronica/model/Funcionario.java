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
	
	public Funcionario(String nome, String CPF, String endereço, String telefone, String email,
			boolean isFuncionario, boolean isExcuído, int matricula, boolean isGerente,
			boolean isExcluído, int idFunc) {
		super(nome, CPF, endereço, telefone, email, isExcuído);
		this.NumeroRegistro = matricula;
		this.IsGerente = isGerente;
		this.IsExcluido = isExcluído;
		this.idFuncao = idFunc;
	}

	public Funcionario(int idFuncionario, int idPessoa, String nome, String CPF, boolean isExcluído, int matricula, boolean isGerente, int idFunc) {
		// TODO Auto-generated constructor stub
		super(idPessoa, nome, CPF);
		this.idFuncionario = idFuncionario;
		this.NumeroRegistro = matricula;
		this.IsGerente = isGerente;
		this.IsExcluido = isExcluído;
		this.idFuncao = idFunc;
	}
	
	public Funcionario(int idFuncionario,int idPessoa,String nome, String CPF) {
		super(idPessoa, nome, CPF);
		this.idFuncionario = idFuncionario;
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
