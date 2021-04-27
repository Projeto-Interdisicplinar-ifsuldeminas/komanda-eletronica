package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.ProdutoEstoque;

public class ProdutoEstoqueDao {

	/******************** Adicionando *****************/
	public boolean adicionar(ProdutoEstoque produtoestoque) {
		Connection connection = null;
		boolean sucesso = true;
		try {
			connection = ConnectFactory.createConnection();
			/* SQL */
			String query = "insert into mesa (idprodutoestoque, nome, peso, descricao, informacao, IsExcluido) values(?,?,?,?,?,?)";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1,  produtoestoque.getIdProdutoEstoque());
			prepare.setString(2,  produtoestoque.getNome());
			prepare.setDouble(3,  produtoestoque.getPeso());
			prepare.setString(4,  produtoestoque.getDescri��o());
			prepare.setString(5,  produtoestoque.getInforma��esAdicionais());
			prepare.setBoolean(6,  produtoestoque.isIsExcluido());
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
	public boolean deletar(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = " DELETE FROM mesa WHERE idProdutoEstoque = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, identificacao);
		// retorna true se foi afetado algum registro
		if (stmt.executeUpdate() > 0) {
			return true;
		}

		stmt.close();
		connection.close();
		return false;

	}

	/******************** Consulta por id *****************/
	public List<ProdutoEstoque> consultaid(int identificacao) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String query = "SELECT idMesa, nome FROM Mesa WHERE IdProdutoEstoque = " + identificacao;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		List<ProdutoEstoque> produtoestoque = new ArrayList<>();
		while (resultado.next()) {
			int id = resultado.getInt("idProdutoEstoque");
			String nome = resultado.getString("nome");
			double peso = resultado.getDouble("peso");
			String descricao = resultado.getString("descri��o");
			String informacao = resultado.getString("informa��o");
			boolean  idexcluido = resultado.getBoolean("IsExcluido");
			
			
			produtoestoque.add(new ProdutoEstoque(id, nome, peso,descricao,informacao, idexcluido));
		}
		stmt.close();
		connection.close();
		
		return produtoestoque;

	}

	/******************** Metodo UPDATE *****************/

	public boolean atualizar(ProdutoEstoque produtoestoque, int IdProdutoEstoque) throws SQLException {
		Connection connection = ConnectFactory.createConnection();
		String update = "UPDATE mesa SET nome = ? WHERE produtoestoque.idProdutoEstoque = ?";

		PreparedStatement stmt = connection.prepareStatement(update);
		try {
			stmt = connection.prepareStatement(update);
			stmt.setString(1, produtoestoque.getNome());
			stmt.setDouble(2, produtoestoque.getPeso());
			stmt.setString(3, produtoestoque.getDescri��o());
			stmt.setString(4, produtoestoque.getInforma��esAdicionais());
			stmt.setInt(5, IdProdutoEstoque);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	/******************** Metodo Retornando ProdutoEstoque *****************/

}
