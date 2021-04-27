package br.com.komanda.eletronica.model;

public class LoginFuncionarios {

	private int IdLoginFuncionario;
	private String Senha;
	private int NivelDeAcesso;
	private boolean IsBloqueado;

	private Funcionario funcionario;

	public LoginFuncionarios(int idLoginFuncionario, String senha, int nívelDeAcesso, boolean isBloqueado, Funcionario funcionario) {
		IdLoginFuncionario = idLoginFuncionario;
		Senha = senha;
		NivelDeAcesso = nívelDeAcesso;
		IsBloqueado = isBloqueado;
		this.funcionario = funcionario;
	}
	
	

	public LoginFuncionarios(String senha, int nivelDeAcesso, boolean isBloqueado, Funcionario funcionario) {
		Senha = senha;
		NivelDeAcesso = nivelDeAcesso;
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

	public int getNivelDeAcesso() {
		return NivelDeAcesso;
	}

	public void setNivelDeAcesso(int nivelDeAcesso) {
		NivelDeAcesso = nivelDeAcesso;
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
