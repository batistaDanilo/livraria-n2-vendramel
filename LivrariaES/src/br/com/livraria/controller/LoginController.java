package br.com.livraria.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import br.com.livraria.controller.dao.AdministradorDAO;
import br.com.livraria.controller.dao.UsuarioDAO;
import br.com.livraria.model.Administrador;
import br.com.livraria.model.Cliente;
import br.com.livraria.model.Usuario;
import br.com.livraria.util.FacesUtil;

@ManagedBean
@SessionScoped
public class LoginController {
	private Boolean eCliente;
	private Boolean usuarioCliente;
	private String usuario;
	private String senha;
	private String msg = "E-mail ou Senha inválidos! Verifique, e tente novamente."; 
	
	@PostConstruct
	public void iniciar(){
		Object pessoa=FacesUtil.getAtributoSessaoWeb("pessoa");
		if(pessoa==null){
			eCliente=null;
		}else if(pessoa instanceof Cliente){
			eCliente=true;
		}else{
			eCliente=false;
		}
	}
	public String acessoPublico(){
		
		if(usuarioCliente==true){
			UsuarioDAO dao=new UsuarioDAO();
			Usuario temp=dao.buscarEmailSenha(usuario, senha);	
			if(temp!=null){
				FacesUtil.setAtributoSessaoWeb("pessoa", temp);
				eCliente=true;
				return "/restrito/cliente/minhaPagina.xhtml?faces-redirect=true";
			}else{
				FacesUtil.addMsgErro(msg);
			}
		}else{
			AdministradorDAO dao=new AdministradorDAO();
			Administrador temp=dao.buscarEmailSenha(usuario, senha);	
			if(temp!=null){
				FacesUtil.setAtributoSessaoWeb("pessoa", temp);
				eCliente=false;
				return "/restrito/adm/minhaPagina.xhtml?faces-redirect=true";
			}else{
				FacesUtil.addMsgErro(msg);
			}
		}
		return "/login.xhtml";
	}

	public String encerrarSessao(){
		HttpSession sessao = FacesUtil.getSessaoWeb();		
		sessao.invalidate();
		return"/inicial.xhtml";
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean geteCliente() {
		return eCliente;
	}
	public Boolean getUsuarioCliente() {
		return usuarioCliente;
	}
	public void setUsuarioCliente(Boolean usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}
}
