package br.com.livraria.model;

import java.io.Serializable;
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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length=11,unique=true)
	@NotNull(message="CPF � obrigat�rio!")
	@CPF(message="O CPF inserido n�o � v�lido!")
	private String cpf;

	@Column
	@NotNull(message="Nome � obrigat�rio!")
	private String nome;

	@Column
	@NotNull(message="Sobrenome � obrigat�rio!")
	private String sobrenome;

	@Temporal(TemporalType.DATE)
	@NotNull(message="Data de Nascimento � obrigat�rio!")
	private Date dataNascimento;

	@Column(length=10)
	@NotNull(message="Telefone � obrigat�rio!")
	private String telefone;

	@Column(length=11)
	private String celular;

	@Column(unique=true)
	@NotNull(message="E-mail � obrigat�rio!")
	@Email(message="E-Mail inv�lido!")
	private String email;
	
	@Column(length=10)
	private String telRecado;

	@Column
	private String nomeRecado;

	@Column
	@NotNull(message="Logradouro � obrigat�rio!")
	private String logadouro;

	@Column
	@NotNull(message="N�mero � obrigat�rio!")
	private String numero;

	@Column
	private String Complemento;

	@Column
	@NotNull(message="Bairro é obrigatório!")
	private String bairro;

	@Column
	@NotNull(message="Cidade é obrigatório!")
	private String cidade;

	@Column(length=2)
	@NotNull(message="UF é obrigatório!")
	private String uf;

	@Column
	@NotNull(message="CEP é obrigatório!")
	private String cep;

	// getters e setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelRecado() {
		return telRecado;
	}

	public void setTelRecado(String telRecado) {
		this.telRecado = telRecado;
	}

	public String getNomeRecado() {
		return nomeRecado;
	}

	public void setNomeRecado(String nomeRecado) {
		this.nomeRecado = nomeRecado;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
