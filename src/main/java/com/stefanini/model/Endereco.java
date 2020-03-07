package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -2677033402616224591L;
	
	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_SEQ_ENDERECO")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="CO_SEQ_PESSOA")
	private Pessoa pessoa;
	
	@NotNull
	@Column(name = "DS_LOGRADOURO")
	private String logradouro;
	
	@NotNull
	@Column(name = "DS_COMPLEMENTO")
	private String complemento;
	
	@NotNull
	@Column(name = "DS_BAIRRO")
	private String bairro;
	
	@NotNull
	@Column(name = "DS_CIDADE")
	private String cidade;
	
	@NotNull
	@Column(name = "CO_UF")
	private String uf;
	
	@NotNull
	@Column(name = "DS_CEP")
	private String cep;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
	public String toString() {
		return "\n-----\nEndereco [id=" + id + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]\n-----\n";
	}

	public Endereco(Pessoa pessoa, @NotNull String logradouro, @NotNull String complemento,
			@NotNull String bairro, @NotNull String cidade, @NotNull String uf, @NotNull String cep) {
		super();
		this.pessoa = pessoa;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Endereco() {
	}

}
