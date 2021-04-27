package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.ProdutoCardapio;

public class CadastroCardapioDao {

	/******************** Adicionando *****************/
	public boolean adicionar(ProdutoCardapio produtocardapio) {
		Connection connection = null;
		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();

			String query = "insert into produtocardapio (`Nome`, `Peso`, `Descricao`, `Valor`, `InformacaoesNutricionais`, `QuantidadeDePessoasQueServe`, `IsExcluido`) values(?, ?, ?, ?, ?,?,?)";
			
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setString(1, produtocardapio.getNome());
			prepare.setDouble(2, produtocardapio.getPeso());
			prepare.setString(3, produtocardapio.getDescricao());
			prepare.setDouble(4, produtocardapio.getValor());
			prepare.setString(5, produtocardapio.getInformacoesNutricionais());
			prepare.setInt(6, produtocardapio.getQuantidadeDePessoasQueServe());
			prepare.setBoolean(7, produtocardapio.isIsExcluido());
			prepare.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			sucesso = false;
		}
		/* Fechando a conexao Sql */
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return sucesso;
	}

	/******************** Metodo Deletar *****************/


	/******************** Consulta por id *****************/

	/******************** Metodo UPDATE *****************/

	

}
