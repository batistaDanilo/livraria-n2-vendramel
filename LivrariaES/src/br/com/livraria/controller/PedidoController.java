package br.com.livraria.controller;

import java.util.List;

import br.com.livraria.model.Pedido;

public class PedidoController {
	
	private Pedido pedido;
	private List<Pedido> listaPedido;
	
	public void novo() {
		pedido = new Pedido();	
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	
	public Pedido getPedido() {
		return this.pedido;
	}
}
