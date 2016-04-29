package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.Venda;
import br.com.livraria.util.FacesUtil;

public class VendaDAO {
private Session sessao=FacesUtil.getSessao("sessao");
	
	public void salvar(Venda venda){
		sessao.merge(venda);
	}
	public void excluir(Venda venda){
		sessao.delete(venda);
	}
	@SuppressWarnings("unchecked")
	public List<Venda> listar(){
		
		return sessao.createCriteria(Venda.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Venda> buscarPreenchido(Venda venda){
		
		Example exemplo=Example.create(venda).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Venda.class).add(exemplo).list();
	}
	
	public Venda buscarPorCodigo(Long id){
		
		return sessao.load(Venda.class, id);
	}

}
