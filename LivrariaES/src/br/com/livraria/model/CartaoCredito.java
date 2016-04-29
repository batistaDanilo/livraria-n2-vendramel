package br.com.livraria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
@Table
@Entity
public class CartaoCredito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	@NotNull(message="Bandeira é obrigatório!")
	private String bandeira;
	
	@Column
	@NotNull(message="Número do Cartão é obrigatório!")
	private String numCartao;
	
	@Column
	@NotNull(message="Número de Parcelas é obrigatório!")
	private Integer numParcelas;
	
	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de Vencimento é obrigatório!")
	private Date dataValidade;
	
	@Column
	@NotNull(message="Código de Segurança é obrigatório!")
	private Integer codigoSeguranca;
	
	@Column
	@NotNull(message="Portador é obrigatório!")
	private String portador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Integer getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSeguranca(Integer codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getPortador() {
		return portador;
	}

	public void setPortador(String portador) {
		this.portador = portador;
	}
	
	
}
