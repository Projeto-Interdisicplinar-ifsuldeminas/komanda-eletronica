package br.com.komanda.eletronica.model;

import java.util.Base64;

public class LoginFuncionarios {

	private int IdLoginFuncionario;
	private String Senha;
	private int NivelDeAcesso;
	private boolean IsBloqueado;
	private boolean primeiroAcesso;

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

	public LoginFuncionarios() {
		
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
	
	public boolean isPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}


	/** Criptografando */
	public String criptografiaBase64Encoder(String pValor) {
	    return new String(Base64.getEncoder().encode(pValor.getBytes()));
	}
	
	/** Realizando o inverso */
	public String descriptografiaBase64Decode(String pValor) {
	    return new String(Base64.getDecoder().decode(pValor.getBytes()));
	}
	

}
