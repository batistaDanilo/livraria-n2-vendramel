package br.com.livraria.controller.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.livraria.model.Cliente;
import br.com.livraria.model.Usuario;
import br.com.livraria.util.FacesUtil;

public class UsuarioDAO {
	private Session sessao = FacesUtil.getSessao("sessao");

	public void salvar(Usuario usuario) {
		sessao.merge(usuario);
	}

	public void excluir(Usuario usuario) {
		sessao.delete(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {

		return sessao.createCriteria(Usuario.class).addOrder(Order.asc("id")).list();

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarPreenchido(Usuario usuario) {

		Example exemplo = Example.create(usuario).enableLike(MatchMode.ANYWHERE);
		return sessao.createCriteria(Usuario.class).add(exemplo).list();
	}

	public Usuario buscarPorCodigo(Long id) {

		return sessao.load(Usuario.class, id);
	}


	public Usuario buscarEmailSenha(String usuario,String senha){
		
		Criteria crit=sessao.createCriteria(Cliente.class);
		crit.add(Restrictions.eq("email", usuario));
		crit.add(Restrictions.eq("senha", FacesUtil.converterMD5(senha)));
		return (Usuario) crit.uniqueResult();
	}
}
