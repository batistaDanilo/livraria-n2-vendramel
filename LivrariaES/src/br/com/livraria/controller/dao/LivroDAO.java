package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.livraria.model.Autor;
import br.com.livraria.model.Editora;
import br.com.livraria.model.Livro;
import br.com.livraria.util.FacesUtil;

public class LivroDAO {
	private Session sessao=FacesUtil.getSessao("sessao");
	
	public void salvar(Livro livro){
		sessao.merge(livro);
	}
	public void excluir(Livro livro){
		sessao.delete(livro);
	}
	@SuppressWarnings("unchecked")
	public List<Livro> listar(){
		
		return sessao.createCriteria(Livro.class).addOrder(Order.asc("id")).list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Livro> buscarPreenchido(Livro livro){
		
		Example exemplo = Example.create(livro).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Livro.class).add(exemplo).list();
	}
	
	public List<Livro> buscarCondicional(Editora editora,Autor autor,String titulo,String categoria){
		Criteria crit= sessao.createCriteria(Livro.class);
		
		if(editora!=null)
			crit.add(Restrictions.eq("editora", editora));
		if(autor!=null)
			crit.add(Restrictions.eq("autor", autor));
		if(titulo!=null && titulo!="")
			crit.add(Restrictions.like("titulo", "%" + titulo + "%"));
		if(categoria!=null && categoria!="")
			crit.add(Restrictions.eq("categoria", categoria));
		
		crit.add(Restrictions.gt("quantidade", 0));
		return crit.list();
	}
	public Livro buscarPorCodigo(Long id){
		
		return sessao.get(Livro.class, id);
	}

}
