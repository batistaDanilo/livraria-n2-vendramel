package br.com.livraria.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.livraria.controller.dao.PedidoDAO;
import br.com.livraria.model.Carrinho;
import br.com.livraria.model.Cliente;
import br.com.livraria.model.Pedido;
import br.com.livraria.model.Situacao;
import br.com.livraria.model.Usuario;
import br.com.livraria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class PedidoController {

	private Pedido pedido;
	private List<Pedido> listaPedido = new ArrayList<>();
	private List<Carrinho> listaCarrinho = new ArrayList<>();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void iniciar() {
		this.listaCarrinho = (List<Carrinho>) FacesUtil.getAtributoSessaoWeb("listaCarrinho");
		if (this.listaCarrinho != null) {
			novo();
			this.pedido.setListaCarrinho(this.listaCarrinho);

			this.pedido.setDataPedido(new Date());
			this.pedido.setValorTotal(calculaPrecoTotal());

			Usuario usu = (Usuario) FacesUtil.getAtributoSessaoWeb("pessoa");
			Cliente cli = usu.getCliente();
			this.pedido.setCliente(cli);

			Situacao status = Situacao.AG;
			this.pedido.setStatusPedido(status);
			
			//salvar();
		} else {
			listar();
		}
	}

	public void listar() {
		PedidoDAO pedidoDAO = new PedidoDAO();
		listaPedido = pedidoDAO.listar();
	}

	public String salvar() {
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.salvar(this.pedido);
		
		return "/restrito/cliente/minhaPagina.xhtml?faces-redirect=true";
	}
	
	public void excluir(Pedido pedido) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.excluir(pedido);
		listar();
	}
	
	public String cancelar() {
		this.pedido = null;
		this.listaPedido = null;
		this.listaCarrinho = null;
		
		return "/restrito/cliente/minhaPagina.xhtml?faces-redirect=true";
	}

	public Double calculaPrecoTotal() {
		Double total = 0.0;
		for (int i = 0; i < listaCarrinho.size(); i++) {
			total += (listaCarrinho.get(i).getQuantidade() * listaCarrinho.get(i).getLivro().getPrecoCusto());
		}
		return total;
	}

	public List<Carrinho> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(List<Carrinho> listaCarrinho) {
		this.listaCarrinho = listaCarrinho;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void novo() {
		this.pedido = new Pedido();
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
