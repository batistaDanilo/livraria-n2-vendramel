package br.com.livraria.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Entity
@Table
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	@NotNull(message="Título é obrigatório!")
	private String titulo;
	
	@Lob
	@Column
	private byte[] imagem;
	
	@Column
	@NotNull(message="ISBN é obrigatório!")
	private String isbn;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de Publicação é obrigatório!")
	private Date dataPublicacao;
	
	@Column
	@NotNull(message="Categoria é obrigatório!")
	private String categoria;
	
	@Column
	@NotNull(message="Resumo é obrigatório!")
	private String resumo;
	
	@Column
	@NotNull(message="Indice é obrigatório!")
	private String indice;
	
	@Column
	@NotNull(message="Preço de Custo é obrigatório!")
	private Double precoCusto;
	
	@Column
	@NotNull(message="Margem de Lucro é obrigatório!")
	private Double margemLucro;
	
	@Column
	@NotNull(message="Quantidade é obrigatório!")
	private Integer quantidade;
	
	@OneToOne
	private Editora editora;
	
	@OneToOne
	private Autor autor;

	public Double calculaPrecoVenda() {
		Double precoVenda = this.getPrecoCusto() + (this.getPrecoCusto() * this.getMargemLucro()/100);
		return precoVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	public StreamedContent getImagePrime(){
	    InputStream in = null;
	    StreamedContent sc;
	    if(this.imagem != null){
	        in = new ByteArrayInputStream(this.imagem);
	    }

	    if( in != null){
	        sc  = new DefaultStreamedContent(in, "image/png");
	    }else{
	        sc = null; 
	    }
	         return sc;
	}
	
	public Double getValor(){
		return calculaPrecoVenda();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(Double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
