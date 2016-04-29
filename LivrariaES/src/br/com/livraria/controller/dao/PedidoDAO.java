package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.Pedido;
import br.com.livraria.util.FacesUtil;

public class PedidoDAO {
private Session sessao=FacesUtil.getSessao("sessao");
	
	public void salvar(Pedido pedido){
		sessao.merge(pedido);
	}
	public void excluir(Pedido pedido){
		sessao.delete(pedido);
	}
	@SuppressWarnings("unchecked")
	public List<Pedido> listar(){
		
		return sessao.createCriteria(Pedido.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Pedido> buscarPreenchido(Pedido pedido){
		
		Example exemplo=Example.create(pedido).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Pedido.class).add(exemplo).list();
	}
	
	public Pedido buscarPorCodigo(Long id){
		
		return sessao.load(Pedido.class, id);
	}

}
