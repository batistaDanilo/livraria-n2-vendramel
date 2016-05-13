package br.com.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.model.Carrinho;
import br.com.livraria.util.FacesUtil;

@ManagedBean
@SessionScoped
public class CarrinhoController {

	private List<Carrinho> listaCarrinho=new ArrayList<>();

	@PostConstruct
	public void iniciar(){
		getListaCarrinho().add((Carrinho) FacesUtil.getAtributoSessaoWeb("carrinho"));
	}
	
	public void remover(Carrinho carrinho){
		getListaCarrinho().remove(carrinho);
	}

	public String finalizar(){
		FacesUtil.setAtributoSessaoWeb("listaCarrinho", listaCarrinho);
		return "/restrito/cliente/finalizarPedido.xhmtl";
	}
	public List<Carrinho> getListaCarrinho() {
		return listaCarrinho;
	}

	public void setListaCarrinho(List<Carrinho> listaCarrinho) {
		this.listaCarrinho = listaCarrinho;
	}
}
