package br.com.komanda.eletronica.model;

public class Funcionario extends Pessoa {
	
	private int idFuncionario;
	private int NumeroRegistro;
	private int idFuncao;
	private boolean IsGerente;
	private boolean IsExcluido;

	public Funcionario(int idPessoa, String nome, String cPF, String endere�o, String telefone, String email,
			boolean isFuncionario, boolean isExcu�do, int idFuncionario, int numeroRegistro, boolean isGerente,
			boolean isExclu�do, int idFunc) {
		super(idPessoa, nome, cPF, endere�o, telefone, email, isExcu�do);
		this.idFuncionario = idFuncionario;
		this.NumeroRegistro = numeroRegistro;
		this.IsGerente = isGerente;
		this.IsExcluido = isExclu�do;
		this.idFuncao = idFunc;
	}
	
	public Funcionario(String nome, String CPF, String endere�o, String telefone, String email,
			boolean isFuncionario, boolean isExcu�do, int matricula, boolean isGerente,
			boolean isExclu�do, int idFunc) {
		super(nome, CPF, endere�o, telefone, email, isExcu�do);
		this.NumeroRegistro = matricula;
		this.IsGerente = isGerente;
		this.IsExcluido = isExclu�do;
		this.idFuncao = idFunc;
	}

	public Funcionario(int idFuncionario, int idPessoa, String nome, String CPF, boolean isExclu�do, int matricula, boolean isGerente, int idFunc) {
		// TODO Auto-generated constructor stub
		super(idPessoa, nome, CPF);
		this.idFuncionario = idFuncionario;
		this.NumeroRegistro = matricula;
		this.IsGerente = isGerente;
		this.IsExcluido = isExclu�do;
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
