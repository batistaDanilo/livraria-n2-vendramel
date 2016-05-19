package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.Editora;
import br.com.livraria.util.FacesUtil;

public class EditoraDAO {
private Session sessao=FacesUtil.getSessao("sessao");
	
	public void salvar(Editora editora){
		sessao.merge(editora);
	}
	public void excluir(Editora editora){
		sessao.delete(editora);
	}
	@SuppressWarnings("unchecked")
	public List<Editora> listar(){
		
		return sessao.createCriteria(Editora.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Editora> buscarPreenchido(Editora editora){
		
		Example exemplo=Example.create(editora).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Editora.class).add(exemplo).list();
	}
	
	public Editora buscarPorCodigo(Long id){
		
		return sessao.get(Editora.class, id);
	}

}
