package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.CartaoCredito;
import br.com.livraria.util.FacesUtil;

public class CartaoCreditoDAO {
private Session sessao=FacesUtil.getSessao("sessao");
	
	public void salvar(CartaoCredito cartaoCredito){
		sessao.merge(cartaoCredito);
	}
	public void excluir(CartaoCredito cartaoCredito){
		sessao.delete(cartaoCredito);
	}
	@SuppressWarnings("unchecked")
	public List<CartaoCredito> listar(){
		
		return sessao.createCriteria(CartaoCredito.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<CartaoCredito> buscarPreenchido(CartaoCredito cartaoCredito){
		
		Example exemplo = Example.create(cartaoCredito).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(CartaoCredito.class).add(exemplo).list();
	}
	
	public CartaoCredito buscarPorCodigo(Long id){
		
		return sessao.load(CartaoCredito.class, id);
	}

}
