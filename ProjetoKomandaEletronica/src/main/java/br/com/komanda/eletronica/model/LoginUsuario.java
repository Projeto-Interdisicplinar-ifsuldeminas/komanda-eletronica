package br.com.komanda.eletronica.model;

public class LoginUsuario {

	private int IdLoginUsuario;
	private String Senha;
	private boolean IsBloqueado;

	private Pessoa pessoa;

	public LoginUsuario(int idLoginUsuario, String senha, boolean isBloqueado, Pessoa pessoa) {
		IdLoginUsuario = idLoginUsuario;
		Senha = senha;
		IsBloqueado = isBloqueado;
		this.pessoa = pessoa;
	}
	
	public void setIdLoginUsuario(int idLoginUsuario) {
		IdLoginUsuario = idLoginUsuario;
	}


	public int getIdLoginUsuario() {
		return IdLoginUsuario;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public boolean isIsBloqueado() {
		return IsBloqueado;
	}

	public void setIsBloqueado(boolean isBloqueado) {
		IsBloqueado = isBloqueado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
}
