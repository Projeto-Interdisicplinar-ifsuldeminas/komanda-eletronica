package br.com.komanda.eletronica.model;

public class Mesa {

	private int IdMesa;
	private String NomeMesa;
	
	
	public Mesa(int idMesa, String nomeMesa) {
		IdMesa = idMesa;
		NomeMesa = nomeMesa;
	}


	public int getIdMesa() {
		return IdMesa;
	}


	public void setIdMesa(int idMesa) {
		IdMesa = idMesa;
	}


	public String getNomeMesa() {
		return NomeMesa;
	}


	public void setNomeMesa(String nomeMesa) {
		NomeMesa = nomeMesa;
	}
		

}
