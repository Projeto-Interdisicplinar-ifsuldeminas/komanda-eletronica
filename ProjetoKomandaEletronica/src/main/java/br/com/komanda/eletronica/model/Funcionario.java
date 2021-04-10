package br.com.komanda.eletronica.model;

import br.com.komanda.eletronica.model.Enums.*;

public class Funcionario extends Pessoa {

	public Funcionario(int idPessoa, String nome, String cPF, String endereço, String telefone, String email,
			boolean isFuncionario, boolean isExcuído) {
		super(idPessoa, nome, cPF, endereço, telefone, email, isFuncionario, isExcuído);
		// TODO Auto-generated constructor stub
	}

	private int idFuncionario;
	private int NumeroRegistro;
	private boolean IsGerente;
	private boolean IsExcluído;
	private String funcao = TiposdeFuncao.Funcao1.getFuncao();

}
