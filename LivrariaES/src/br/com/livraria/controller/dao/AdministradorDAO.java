package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.livraria.model.Cliente;
import br.com.livraria.model.Administrador;
import br.com.livraria.util.FacesUtil;

public class AdministradorDAO {
	private Session sessao = FacesUtil.getSessao("sessao");

	public void salvar(Administrador administrador) {
		sessao.merge(administrador);
	}

	public void excluir(Administrador administrador) {
		sessao.delete(administrador);
	}

	@SuppressWarnings("unchecked")
	public List<Administrador> listar() {

		return sessao.createCriteria(Administrador.class).addOrder(Order.asc("id")).list();

	}

	@SuppressWarnings("unchecked")
	public List<Administrador> buscarPreenchido(Administrador administrador) {

		Example exemplo = Example.create(administrador).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Administrador.class).add(exemplo).list();
	}

	public Administrador buscarPorCodigo(Long id) {

		return sessao.load(Administrador.class, id);
	}


	public Administrador buscarEmailSenha(String usuario,String senha){
		
		Criteria crit=sessao.createCriteria(Cliente.class);
		crit.add(Restrictions.eq("email", usuario));
		crit.add(Restrictions.eq("senha", FacesUtil.converterMD5(senha)));
		return (Administrador) crit.uniqueResult();
	}

}
