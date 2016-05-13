package br.com.livraria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.controller.dao.AutorDAO;
import br.com.livraria.controller.dao.EditoraDAO;
import br.com.livraria.controller.dao.LivroDAO;
import br.com.livraria.model.Autor;
import br.com.livraria.model.Carrinho;
import br.com.livraria.model.Cliente;
import br.com.livraria.model.Editora;
import br.com.livraria.model.Livro;
import br.com.livraria.util.FacesUtil;

@ManagedBean
@SessionScoped
public class LivroController {

	private List<Autor> listaAutor;
	private List<Editora> listaEditora;
	private List<Livro> listaLivro;
	private List<Livro> listaLivroBusca;

	private Livro livro;
	private Livro livroBusca;
	private Carrinho carrinho;
	private Cliente cliente;
	
	private Editora editoraSelecionada;
	private Autor autorSelecionado;
	private String categoriaSelecionada;
	private String tituloSelecionado;

	@PostConstruct
	public void iniciar() {
		livroBusca=new Livro();
		listar();
	}

	public String cadastrar() {
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.salvar(livro);
		listar();
		return "/restrito/adm/consultarLivro.xhtml?faces-redirect=true";
	}

	public void excluir(Livro livro) {
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.excluir(livro);
		listar();
	}
	
	public String editar(Livro livro){
		this.livro=livro;
		return "cadastrarLivro.xhtml?faces-redirect=true";
	}
	public void listar() {
		LivroDAO livroDAO = new LivroDAO();
		listaLivro= livroDAO.listar();

		AutorDAO autorDAO = new AutorDAO();
		listaAutor = autorDAO.listar();

		EditoraDAO editoraDAO = new EditoraDAO();
		listaEditora = editoraDAO.listar();

	}

	public String novo() {
		livro = new Livro();
		return "cadastrarLivro.xhtml?faces-redirect=true";
	}

	public String adicionarCarrinho(Livro livro){
		carrinho.setLivro(livro);
		carrinho.setQuantidade(new Integer(1));
		FacesUtil.setAtributoSessaoWeb("carrinho", carrinho);
		return "/restrito/cliente/carrinho.xhtml";
	}
	
	public void removerCarrinho(){
		
	}
	
	public void buscar(){
		LivroDAO livroDAO=new LivroDAO();
		listaLivroBusca=livroDAO.buscarCondicional(editoraSelecionada, autorSelecionado, tituloSelecionado, categoriaSelecionada);
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public List<Editora> getListaEditora() {
		return listaEditora;
	}

	public void setListaEditora(List<Editora> listaEditora) {
		this.listaEditora = listaEditora;
	}

	public List<Livro> getListaLivro() {
		return listaLivro;
	}

	public void setListaLivro(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Livro getLivroBusca() {
		return livroBusca;
	}

	public void setLivroBusca(Livro livroBusca) {
		this.livroBusca = livroBusca;
	}

	public List<Livro> getListaLivroBusca() {
		return listaLivroBusca;
	}

	public void setListaLivroBusca(List<Livro> listaLivroBusca) {
		this.listaLivroBusca = listaLivroBusca;
	}

	public Editora getEditoraSelecionada() {
		return editoraSelecionada;
	}

	public void setEditoraSelecionada(Editora editoraSelecionada) {
		this.editoraSelecionada = editoraSelecionada;
	}

	public Autor getAutorSelecionado() {
		return autorSelecionado;
	}

	public void setAutorSelecionado(Autor autorSelecionado) {
		this.autorSelecionado = autorSelecionado;
	}

	public String getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(String categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public String getTituloSelecionado() {
		return tituloSelecionado;
	}

	public void setTituloSelecionado(String tituloSelecionado) {
		this.tituloSelecionado = tituloSelecionado;
	}
}
