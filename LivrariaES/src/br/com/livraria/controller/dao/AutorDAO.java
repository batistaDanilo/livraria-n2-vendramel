package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.Autor;
import br.com.livraria.util.FacesUtil;

public class AutorDAO {
	private Session sessao=FacesUtil.getSessao("sessao");
	
	public void salvar(Autor autor){
		sessao.merge(autor);
	}
	public void excluir(Autor autor){
		sessao.delete(autor);
	}
	@SuppressWarnings("unchecked")
	public List<Autor> listar(){
		
		return sessao.createCriteria(Autor.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Autor> buscarPreenchido(Autor autor){
		
		Example exemplo=Example.create(autor).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Autor.class).add(exemplo).list();
	}
	
	public Autor buscarPorCodigo(Long id){
		
		return sessao.load(Autor.class, id);
	}
	
}
