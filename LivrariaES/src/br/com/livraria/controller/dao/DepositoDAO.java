package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.Deposito;
import br.com.livraria.util.FacesUtil;

public class DepositoDAO {
private Session sessao=FacesUtil.getSessao("sessao");
	
	public void salvar(Deposito deposito){
		sessao.merge(deposito);
	}
	public void excluir(Deposito deposito){
		sessao.delete(deposito);
	}
	@SuppressWarnings("unchecked")
	public List<Deposito> listar(){
		
		return sessao.createCriteria(Deposito.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Deposito> buscarPreenchido(Deposito deposito){
		
		Example exemplo = Example.create(deposito).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Deposito.class).add(exemplo).list();
	}
	
	public Deposito buscarPorCodigo(Long id){
		
		return sessao.load(Deposito.class, id);
	}

}
