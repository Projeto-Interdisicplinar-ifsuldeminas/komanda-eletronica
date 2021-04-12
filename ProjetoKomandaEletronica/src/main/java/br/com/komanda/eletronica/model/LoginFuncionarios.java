package br.com.komanda.eletronica.model;

public class LoginFuncionarios {

	private int IdLoginFuncionario;
	private String Senha;
	private int N�velDeAcesso;
	private boolean IsBloqueado;

	private Funcionario funcionario;

	public LoginFuncionarios(int idLoginFuncionario, String senha, int n�velDeAcesso, boolean isBloqueado, Funcionario funcionario) {
		IdLoginFuncionario = idLoginFuncionario;
		Senha = senha;
		N�velDeAcesso = n�velDeAcesso;
		IsBloqueado = isBloqueado;
		this.funcionario = funcionario;
	}

	public int getIdLoginFuncionario() {
		return IdLoginFuncionario;
	}
	
	public void setIdLoginFuncionario(int idLoginFuncionario) {
		IdLoginFuncionario = idLoginFuncionario;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public int getN�velDeAcesso() {
		return N�velDeAcesso;
	}

	public void setN�velDeAcesso(int n�velDeAcesso) {
		N�velDeAcesso = n�velDeAcesso;
	}

	public boolean isIsBloqueado() {
		return IsBloqueado;
	}

	public void setIsBloqueado(boolean isBloqueado) {
		IsBloqueado = isBloqueado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
