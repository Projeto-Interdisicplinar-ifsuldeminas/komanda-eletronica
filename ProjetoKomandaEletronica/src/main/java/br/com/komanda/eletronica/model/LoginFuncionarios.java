package br.com.komanda.eletronica.model;

public class LoginFuncionarios {

	private int IdLoginFuncionario;
	private String Senha;
	private int NívelDeAcesso;
	private boolean IsBloqueado;

	private Funcionario funcionario;

	public LoginFuncionarios(int idLoginFuncionario, String senha, int nívelDeAcesso, boolean isBloqueado, Funcionario funcionario) {
		IdLoginFuncionario = idLoginFuncionario;
		Senha = senha;
		NívelDeAcesso = nívelDeAcesso;
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

	public int getNívelDeAcesso() {
		return NívelDeAcesso;
	}

	public void setNívelDeAcesso(int nívelDeAcesso) {
		NívelDeAcesso = nívelDeAcesso;
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
