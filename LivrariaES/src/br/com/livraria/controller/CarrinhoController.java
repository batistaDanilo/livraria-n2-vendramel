package br.com.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.model.Carrinho;
import br.com.livraria.model.Livro;
import br.com.livraria.util.FacesUtil;

@ManagedBean
@SessionScoped
public class CarrinhoController {

	private List<Carrinho> listaCarrinho = new ArrayList<>();

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void iniciar() {
		listaCarrinho = (List<Carrinho>) FacesUtil.getAtributoSessaoWeb("listaCarrinho");
	}

	public void remover(Carrinho carrinho) {
		getListaCarrinho().remove(carrinho);
	}

	public String finalizar() {
		FacesUtil.setAtributoSessaoWeb("listaCarrinho", listaCarrinho);
		return "/restrito/cliente/finalizarPedido.xhmtl?faces-redirect=true";
	}

	public List<Carrinho> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(List<Carrinho> listaCarrinho) {
		this.listaCarrinho = listaCarrinho;
	}
	
}