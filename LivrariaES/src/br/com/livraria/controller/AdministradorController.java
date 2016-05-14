package br.com.livraria.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.livraria.controller.dao.AdministradorDAO;
import br.com.livraria.model.Administrador;
import br.com.livraria.util.FacesUtil;
@ManagedBean
@ViewScoped
public class AdministradorController {
	private Administrador administrador;
	@PostConstruct
	public void iniciar() {
		Administrador usuario=(Administrador) FacesUtil.getAtributoSessaoWeb("pessoa");
		
		if(usuario!=null){
			setAdministrador(usuario);
		}else{
			this.setAdministrador(new Administrador());
		}
	}

	public String cadastrar() {
		AdministradorDAO dao = new AdministradorDAO();
		dao.salvar(getAdministrador());
		return "/login.xhtml?faces-redirect=true";
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

}
