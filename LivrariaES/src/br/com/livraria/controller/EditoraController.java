package br.com.livraria.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.controller.dao.EditoraDAO;
import br.com.livraria.model.Editora;

@ManagedBean
@SessionScoped
public class EditoraController {

	private List<Editora> listaEditora;
	
	private Editora editora;

	public String editar(Editora editora) {
		this.editora = editora;
		return "cadastrarEditora.xhtml?faces-redirect=true";
	}

	public void excluir(Editora editora){
		EditoraDAO editoraDAO = new EditoraDAO();
		editoraDAO.excluir(editora);
		listar();
	}
	
	public void listar(){
		EditoraDAO editoraDAO = new EditoraDAO();
		listaEditora = editoraDAO.listar();
	}
	
	public String novo(){
		editora = new Editora();
		return "cadastrarEditora.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void iniciar(){
		listar();
	}
	
	public void setListaEditora(List<Editora> listaEditora) {
		this.listaEditora = listaEditora;
	}

	public List<Editora> getListaEditora() {
		return this.listaEditora;
	}
	
	public String cadastrar(){
		EditoraDAO editoraDAO = new EditoraDAO();
		editoraDAO.salvar(editora);
		listar();
		return "/restrito/adm/consultarEditora.xhtml?faces-redirect=true";
	}
	
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public Editora getEditora() {
		return this.editora;
	}
}
