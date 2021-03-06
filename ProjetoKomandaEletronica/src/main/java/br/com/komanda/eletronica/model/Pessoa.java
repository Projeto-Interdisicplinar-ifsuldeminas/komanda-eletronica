package br.com.komanda.eletronica.model;

public class Pessoa {

	private int IdPessoa;
	private String Nome;
	private String CPF;
	private String Endere?o;
	private String Telefone;
	private String Email;
	private boolean IsExcluido;

	public Pessoa(int idPessoa, String nome, String cPF, String endere?o, String telefone, String email, boolean isExclu?do) {
		IdPessoa = idPessoa;
		Nome = nome;
		CPF = cPF;
		Endere?o = endere?o;
		Telefone = telefone;
		Email = email;
		IsExcluido = isExclu?do;
	}

	

	public Pessoa(int idPessoa, String nome, String cPF, String endere?o, String telefone, String email) {
		IdPessoa = idPessoa;
		Nome = nome;
		CPF = cPF;
		Endere?o = endere?o;
		Telefone = telefone;
		Email = email;
	}



	public Pessoa(String nome, String cPF, String endere?o, String telefone, String email, boolean isExclu?do) {
		Nome = nome;
		CPF = cPF;
		Endere?o = endere?o;
		Telefone = telefone;
		Email = email;
	}



	public Pessoa(int idPessoa, String nome, String cPF) {
		// TODO Auto-generated constructor stub
		IdPessoa = idPessoa;
		Nome = nome;
		CPF = cPF;
	}



	public int getIdPessoa() {
		return IdPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		IdPessoa = idPessoa;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEndere?o() {
		return Endere?o;
	}

	public void setEndere?o(String endere?o) {
		Endere?o = endere?o;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isIsExclu?do() {
		return IsExcluido;
	}

	public void setIsExcluido(boolean isExcluido) {
		IsExcluido = isExcluido;
	}

}
