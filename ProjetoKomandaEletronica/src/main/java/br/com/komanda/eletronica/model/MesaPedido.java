package br.com.komanda.eletronica.model;

import java.util.ArrayList;
import java.util.Date;

public class MesaPedido {

	private int IdMesaPedido;
	private double ValorTotal;
	private Pedido pedido;
	private ArrayList<Pedido> pedidos = new ArrayList<>();

	private Mesa mesa;
	private Date date;
	public MesaPedido(int idMesaPedido, Mesa mesa, Date date) {
		IdMesaPedido = idMesaPedido;
		ValorTotal = 0.00;
		this.mesa = mesa;
		this.date = date;
	}
	
	public MesaPedido() {
		
	}
	
	public int getIdMesaPedido() {
		return IdMesaPedido;
	}
	public void setIdMesaPedido(int idMesaPedido) {
		IdMesaPedido = idMesaPedido;
	}
	public double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void AdicionaPedidos(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public ArrayList<Pedido> RetornaPedidos(){
		return pedidos;
	}
	
	public void setListaDePedidos(ArrayList<Pedido> lista) {
		pedidos = lista;
	}

}
