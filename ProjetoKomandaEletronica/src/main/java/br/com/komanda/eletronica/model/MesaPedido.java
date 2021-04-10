package br.com.komanda.eletronica.model;

import java.util.ArrayList;
import java.util.Date;

public class MesaPedido {

	private int IdMesaPedido;
	private double ValorTotal;
	ArrayList<Pedido> pedidos = new ArrayList<>();

	Mesa mesa;
	Date date;

}
