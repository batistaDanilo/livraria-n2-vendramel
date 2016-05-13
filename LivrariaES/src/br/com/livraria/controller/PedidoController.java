package br.com.livraria.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.model.Carrinho;
import br.com.livraria.model.Cliente;
import br.com.livraria.model.Pedido;
import br.com.livraria.model.Situacao;
import br.com.livraria.util.FacesUtil;

@ManagedBean
@SessionScoped
public class PedidoController {
	private List<Carrinho> listaCarrinho;
	private Pedido pedido;
	
	@PostConstruct
	private void iniciar(){
		listaCarrinho=(List<Carrinho>) FacesUtil.getAtributoSessaoWeb("listaCarrinho");
		pedido=new Pedido();
		pedido.setCliente((Cliente) FacesUtil.getAtributoSessaoWeb("cliente"));
		pedido.setDataPedido(new Date());
		pedido.setStatusPedido(Situacao.AG);
		
		BigDecimal resultado=new BigDecimal(0);
		
		for(Carrinho c:listaCarrinho){
			BigDecimal valor=c.getLivro().getPrecoCusto();
			
			BigDecimal parcial=valor.multiply(new BigDecimal(c.getQuantidade()));
			resultado.add(parcial);
			
		}
		pedido.setValorTotal(resultado);
	}
	public List<Carrinho> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(List<Carrinho> listaCarrinho) {
		this.listaCarrinho = listaCarrinho;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
