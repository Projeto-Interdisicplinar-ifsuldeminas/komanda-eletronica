package br.com.komanda.eletronica.model;

public class CozinhaPedido {

	private int IdPedidoCozinha;
	private String Status;

	private MesaPedido mesaPedido;
	private Delivery delivery;
	private Mesa mesa;	
	
	public CozinhaPedido(int idPedidoCozinha, String status, MesaPedido mesaPedido, Delivery delivery, Mesa mesa) {
		IdPedidoCozinha = idPedidoCozinha;
		Status = status;
		this.mesaPedido = mesaPedido;
		this.delivery = delivery;
		this.mesa = mesa;
	}


	public int getIdPedidoCozinha() {
		return IdPedidoCozinha;
	}


	public void setIdPedidoCozinha(int idPedidoCozinha) {
		IdPedidoCozinha = idPedidoCozinha;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public MesaPedido getMesaPedido() {
		return mesaPedido;
	}


	public void setMesaPedido(MesaPedido mesaPedido) {
		this.mesaPedido = mesaPedido;
	}


	public Delivery getDelivery() {
		return delivery;
	}


	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}


	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	

}
