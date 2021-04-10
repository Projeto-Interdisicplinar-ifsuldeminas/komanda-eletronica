package br.com.komanda.eletronica.model;

public class Pessoa {

	private int IdPessoa;
	private String Nome;
	private String CPF;
	private String Endereço;
	private String Telefone;
	private String Email;
	private boolean IsFuncionario;
	private boolean IsExcuído;

	public Pessoa(int idPessoa, String nome, String cPF, String endereço, String telefone, String email,
			boolean isFuncionario, boolean isExcuído) {
		super();
		IdPessoa = idPessoa;
		Nome = nome;
		CPF = cPF;
		Endereço = endereço;
		Telefone = telefone;
		Email = email;
		IsFuncionario = isFuncionario;
		IsExcuído = isExcuído;
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

	public String getEndereço() {
		return Endereço;
	}

	public void setEndereço(String endereço) {
		Endereço = endereço;
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

	public boolean isIsFuncionario() {
		return IsFuncionario;
	}

	public void setIsFuncionario(boolean isFuncionario) {
		IsFuncionario = isFuncionario;
	}

	public boolean isIsExcuído() {
		return IsExcuído;
	}

	public void setIsExcuído(boolean isExcuído) {
		IsExcuído = isExcuído;
	}

}
