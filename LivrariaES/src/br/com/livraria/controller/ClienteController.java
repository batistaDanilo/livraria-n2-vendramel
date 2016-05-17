package br.com.livraria.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.livraria.controller.dao.ClienteDAO;
import br.com.livraria.controller.dao.UsuarioDAO;
import br.com.livraria.model.Cliente;
import br.com.livraria.model.Usuario;
import br.com.livraria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteController {
	private Cliente cliente;
	private Usuario usuario;

	@PostConstruct
	public void iniciar() {
		Usuario usuario = (Usuario) FacesUtil.getAtributoSessaoWeb("pessoa");

		if (usuario != null) {
			cliente = usuario.getCliente();
			this.usuario = usuario;
		} else {
			this.cliente = new Cliente();
			this.usuario = new Usuario();
		}
	}

	public String cadastrar() {
		ClienteDAO dao = new ClienteDAO();
		cliente = dao.salvar(cliente);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario.setCliente(cliente);
		usuario.setDataCadastro(new Date());
		usuario.setSenha(FacesUtil.converterMD5(usuario.getSenha()));
		usuarioDAO.salvar(usuario);

		return "/login.xhtml?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}