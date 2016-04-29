package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import br.com.livraria.model.Promocao;
import br.com.livraria.util.FacesUtil;

public class PromocaoDAO {
	private Session sessao = FacesUtil.getSessao("sessao");

	public void salvar(Promocao promocao) {
		sessao.merge(promocao);
	}

	public void excluir(Promocao promocao) {
		sessao.delete(promocao);
	}

	@SuppressWarnings("unchecked")
	public List<Promocao> listar() {

		return sessao.createCriteria(Promocao.class).addOrder(Order.asc("id")).list();

	}

	@SuppressWarnings("unchecked")
	public List<Promocao> buscarPreenchido(Promocao promocao) {

		Example exemplo = Example.create(promocao).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Promocao.class).add(exemplo).list();
	}

	public Promocao buscarPorCodigo(Long id) {

		return sessao.load(Promocao.class, id);
	}

}
