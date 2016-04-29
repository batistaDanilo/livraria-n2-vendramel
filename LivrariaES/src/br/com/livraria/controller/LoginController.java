package br.com.livraria.controller;

import br.com.livraria.controller.dao.AdministradorDAO;
import br.com.livraria.controller.dao.UsuarioDAO;
import br.com.livraria.model.Administrador;
import br.com.livraria.model.Usuario;
import br.com.livraria.util.FacesUtil;

public class LoginController {
	boolean eCliente=true;
	private String email;
	private String senha;
	private String msg = "E-mail ou Senha inv�lidos! Verifique, e tente novamente."; 

	public String acessoPublico(){
		
		if(eCliente==true){
			UsuarioDAO dao=new UsuarioDAO();
			Usuario temp=dao.buscarEmailSenha(email, senha);	
			if(temp!=null){
				FacesUtil.setAtributoSessaoWeb("pessoa", temp);
				return "/restrito/cliente/minhaPagina.xhtml?faces-redirect=true";
			}else{
				FacesUtil.addMsgErro(msg);
			}
		}else{
			AdministradorDAO dao=new AdministradorDAO();
			Administrador temp=dao.buscarEmailSenha(email, senha);	
			if(temp!=null){
				FacesUtil.setAtributoSessaoWeb("pessoa", temp);
				return "/restrito/administrador/minhaPagina.xhtml?faces-redirect=true";
			}else{
				FacesUtil.addMsgErro(msg);
			}
		}
		return "/login.xhtml";
	}
	
//	public String acessoInterno(){
//		AdministradorDAO daoA=new AdministradorDAO();
//		Administrador tempA=daoA.buscarEmailSenha(email, senha);	
//		if(tempA!=null){
//			FacesUtil.setAtributoSessaoWeb("pessoa", tempA);
//			return "/restrito/adm/menu.xhtml?faces-redirect=true";
//		}else{
//			FacesUtil.addMsgErro(msg);
//		}
//		return "/login.xhtml";
//	}
//	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
