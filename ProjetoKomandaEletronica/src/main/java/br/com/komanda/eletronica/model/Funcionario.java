package br.com.komanda.eletronica.model;

import br.com.komanda.eletronica.model.Enums.*;

public class Funcionario extends Pessoa {

	public Funcionario(int idPessoa, String nome, String cPF, String endere�o, String telefone, String email,
			boolean isFuncionario, boolean isExcu�do) {
		super(idPessoa, nome, cPF, endere�o, telefone, email, isFuncionario, isExcu�do);
		// TODO Auto-generated constructor stub
	}

	private int idFuncionario;
	private int NumeroRegistro;
	private boolean IsGerente;
	private boolean IsExclu�do;
	private String funcao = TiposdeFuncao.Funcao1.getFuncao();

}
