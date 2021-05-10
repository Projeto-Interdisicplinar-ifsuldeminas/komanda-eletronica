package br.com.komanda.eletronica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.komanda.eletronica.connection.ConnectFactory;
import br.com.komanda.eletronica.model.MesaPedido;
import br.com.komanda.eletronica.model.Pedido;
import br.com.komanda.eletronica.model.Xml;

public class PedidoDao {

	/******************** Adicionando *****************/
	public boolean adicionar(MesaPedido pedido) throws Exception {
		Connection connection = null;
		boolean sucesso = true;
		MesaPedido mesaPedido = pedido;
		try {
			ConnectFactory conection = null;
			Xml xml = new Xml();			
			conection = xml.lerXML();
			connection = ConnectFactory.createConnection(conection.getServer(), conection.getPorta(), conection.getNome(), conection.getUser(), conection.getSenha());
			/* SQL */
			String query = "INSERT INTO pedido (Data) VALUES (NOW());";
			/* Preparando a Query */
			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.execute();
			
			String sql = "SELECT IdPedido from pedido where IdPedido = (select max(IdPedido) from pedido);";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int lastId = rs.getInt("IdPedido");
			
			String queryMesaPedido = "INSERT INTO mesapedido (IdMesa, ValorTotal, Data) VALUES (?, ?, NOW());";
			/* Preparando a Query */
			PreparedStatement prepare_Mesa_Pedido = connection.prepareStatement(queryMesaPedido);
			prepare_Mesa_Pedido.setInt(1, mesaPedido.getMesa().getIdMesa());
			prepare_Mesa_Pedido.setDouble(2, mesaPedido.getValorTotal());
			prepare_Mesa_Pedido.execute();
			
			String sql1 = "SELECT IdMesaPedido from mesapedido where IdMesaPedido = (select max(IdMesaPedido) from mesapedido);";
			PreparedStatement stmt1 = (PreparedStatement) connection.prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery();
			rs1.next();
			int MesaPedidoId = rs1.getInt("IdMesaPedido");
			
			String queryPedidoMesaPedido = "INSERT INTO pedidomesapedido(IdPedido, IdMesaPedido) VALUES (?, ?);";
			/* Preparando a Query */
			PreparedStatement prepare_Pedido_Mesa_Pedido = connection.prepareStatement(queryPedidoMesaPedido);
			prepare_Pedido_Mesa_Pedido.setInt(1, lastId);
			prepare_Pedido_Mesa_Pedido.setInt(2, MesaPedidoId);
			prepare_Pedido_Mesa_Pedido.execute();
			
			ArrayList<Pedido> lista = new ArrayList<>();
			lista = mesaPedido.RetornaPedidos();			
			for(int i=0; i < lista.size(); i++) {
				String queryCardapioPedido = "INSERT INTO produtocardapiopedido (IdProdutoCardapio, IdPedido, Quantidade, Status) VALUES (?, ?, ?, ?);";
				/* Preparando a Query */
				PreparedStatement prepare_C_P = connection.prepareStatement(queryCardapioPedido);
				prepare_C_P.setInt(1, lista.get(i).getProdutoCardapio().getIdProdutoCardapio());
				prepare_C_P.setInt(2, lastId);
				prepare_C_P.setInt(3, lista.get(i).getQuantidade());
				prepare_C_P.setInt(4, 1);
				prepare_C_P.execute();
			}

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

	/******************** Metodo Retornando Mesas *****************/

}
