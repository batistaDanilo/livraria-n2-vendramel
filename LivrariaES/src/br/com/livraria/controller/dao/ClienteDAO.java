package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.Cliente;
import br.com.livraria.util.FacesUtil;

public class ClienteDAO {
	private Session sessao=FacesUtil.getSessao("sessao");
	
	public Cliente salvar(Cliente cliente){
		return (Cliente) sessao.merge(cliente);
	}
	public void excluir(Cliente cliente){
		sessao.delete(cliente);
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> listar(){
		
		return sessao.createCriteria(Cliente.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarPreenchido(Cliente cliente){
		
		Example exemplo=Example.create(cliente).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Cliente.class).add(exemplo).list();
	}
	
	public Cliente buscarPorCodigo(Long id){
		
		return sessao.load(Cliente.class, id);
	}
	
}
