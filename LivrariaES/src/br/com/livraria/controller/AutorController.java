package br.com.livraria.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.controller.dao.AutorDAO;
import br.com.livraria.model.Autor;

@ManagedBean
@SessionScoped
public class AutorController {

	private List<Autor> listaAutor;
	
	private Autor autor;
	
	public String editar(Autor autor) {
		this.autor=autor;
		return "cadastrarAutor.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void iniciar(){
		listar();
	}
	
	public void excluir(Autor autor){
		AutorDAO autorDAO = new AutorDAO();
		autorDAO.excluir(autor);
		listar();
	}
	
	public void listar(){
		AutorDAO autorDAO = new AutorDAO();
		listaAutor= autorDAO.listar();
	}
	
	public String novo(){
		autor = new Autor();
		return "cadastrarAutor.xhtml?faces-redirect=true";
	}
	
	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}
	
	public List<Autor> getListaAutor() {
		return this.listaAutor;
	}
	
	public String cadastrar(){
		AutorDAO autorDAO = new AutorDAO();
		autorDAO.salvar(autor);
		listar();
		return "/restrito/adm/consultarAutor.xhtml?faces-redirect=true";
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public Autor getAutor() {
		return this.autor;
	}

}
